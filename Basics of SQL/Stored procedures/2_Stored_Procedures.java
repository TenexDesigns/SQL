Stored procedures are precompiled collections of SQL statements that can be executed as a single unit. They offer several advantages over individual SQL statements, including:

* **Code Reusability:** Stored procedures allow you to encapsulate frequently used SQL code and reuse it across different queries, reducing redundancy and improving code maintainability.

* **Parameterization:** Stored procedures can be parameterized, allowing you to pass in values at runtime, making them more flexible and adaptable to different scenarios.

* **Performance Improvement:** Stored procedures can improve query performance by reducing network traffic and enabling server-side precompilation, especially for complex queries that are executed frequently.

* **Encapsulation of Business Logic:** Stored procedures can encapsulate complex business logic, ensuring consistent data manipulation and reducing the risk of errors.

* **Separation of Concerns:** Stored procedures can separate data access logic from application logic, promoting modularity and easier maintenance.

**Common Use Cases of Stored Procedures:**

1. **Data Validation and Integrity:** Stored procedures can enforce data validation rules and integrity constraints, ensuring the quality and consistency of data before it is stored in the database.

2. **Complex Data Manipulation:** Stored procedures can handle complex data manipulation tasks, such as performing multiple operations in a single transaction or processing large amounts of data efficiently.

3. **Encapsulating Security Logic:** Stored procedures can encapsulate security checks and authorization rules, limiting access to sensitive data and preventing unauthorized operations.

4. **Simplifying Application Logic:** Stored procedures can simplify application logic by providing a centralized location for data manipulation and business rules, reducing the complexity of application code.

5. **Enhancing Code Organization:** Stored procedures can improve code organization by grouping related SQL statements into reusable units, making the code more readable and easier to maintain.

**Examples of Stored Procedures:**

1. **User Registration with Validation:**

```sql
CREATE PROCEDURE register_user(
  IN user_name VARCHAR(50),
  IN user_email VARCHAR(100),
  IN user_password VARCHAR(255)
)
BEGIN
  -- Check if user already exists
  IF EXISTS(SELECT * FROM users WHERE user_email = user_email) THEN
    SIGNAL SQLSTATE '23000' SET MESSAGE_TEXT = 'User email already exists';
  END IF;

  -- Insert new user record
  INSERT INTO users (user_name, user_email, user_password)
  VALUES (user_name, user_email, user_password);
END;
```

2. **Calculating Order Total with Discounts:**

```sql
CREATE PROCEDURE calculate_order_total(
  IN order_id INT,
  OUT total_amount DECIMAL(10,2)
)
BEGIN
  -- Calculate order total
  SELECT SUM(order_items.quantity * product_prices.unit_price)
  INTO total_amount
  FROM order_items
  JOIN products ON order_items.product_id = products.product_id
  WHERE order_items.order_id = order_id;

  -- Apply discounts based on order amount
  IF total_amount > 100 THEN
    SET total_amount = total_amount * 0.95;
  END IF;
END;
```

3. **Encapsulating Security Logic for User Login:**

```sql
CREATE PROCEDURE check_user_credentials(
  IN user_email VARCHAR(100),
  IN user_password VARCHAR(255),
  OUT valid_login TINYINT(1)
)
BEGIN
  -- Check if user exists and credentials match
  SELECT 1
  INTO valid_login
  FROM users
  WHERE user_email = user_email AND user_password = user_password;

  IF NOT valid_login THEN
    SET valid_login = 0;
  END IF;
END;
```

Stored procedures provide a powerful tool for encapsulating complex logic, enhancing code reusability, and improving performance in SQL applications. They are widely used in database-driven applications to manage data efficiently and enforce business rules.


  ..
