A Common Table Expression (CTE) is a temporary result set that you can reference within a SELECT, INSERT, UPDATE, or DELETE statement in SQL. CTEs are used to simplify complex queries and make them more readable by breaking them into smaller, more manageable parts. CTEs are defined using the `WITH` clause and can be referenced within the query where they are defined.

Here's the basic syntax for creating and using a CTE:

```sql
WITH cte_name (column1, column2, ...) AS (
    -- CTE query here
)
SELECT * FROM cte_name;
```

- `cte_name`: The name of the CTE.
- `(column1, column2, ...)`: An optional column list to define the structure of the CTE, typically used when creating temporary tables.
- `WITH`: The keyword to start the CTE definition.
- `AS`: The keyword to indicate the beginning of the query for the CTE.

Here's an example of how to use a CTE to simplify a query:

```sql
WITH HighSalaryEmployees AS (
    SELECT employee_name, salary
    FROM employees
    WHERE salary > 50000
)
SELECT * FROM HighSalaryEmployees;
```

In this example, a CTE named "HighSalaryEmployees" is created to hold the result of employees with a salary greater than $50,000. The CTE is then referenced in the SELECT statement to retrieve the data. This makes the code more readable and separates the logic of filtering high-salary employees from the final SELECT statement.

Key points about CTEs:

1. CTEs can be referenced only within the statement in which they are defined. They cannot be used across multiple statements.

2. CTEs are often used for recursive queries, where a query refers to its own output.

3. CTEs can improve query performance by allowing the database engine to optimize the execution plan.

4. CTEs are a useful tool for simplifying complex queries and breaking them into smaller, more understandable parts, enhancing query readability and maintainability.

5. CTEs can be used in SELECT, INSERT, UPDATE, and DELETE statements, depending on your specific needs.

6. You can define multiple CTEs in a single query, and they can reference each other or reference themselves in the case of recursive CTEs.

CTEs are a valuable feature in SQL, particularly for complex queries or when you want to make your code more modular and understandable by breaking it into manageable pieces.
