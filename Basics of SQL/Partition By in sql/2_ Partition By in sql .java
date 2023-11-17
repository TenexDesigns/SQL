The PARTITION BY clause is used in SQL to divide the result set of a query into partitions or groups based on a specified column or expression. It is commonly used with window functions to perform calculations on each partition separately. Here are some key points about the PARTITION BY clause:

- The PARTITION BY clause is used in conjunction with window functions to define the partitioning scheme for the function.
- It divides the result set into partitions or groups based on the specified column or expression.
- The window function is then applied to each partition separately, calculating the result based on the values within that partition.
- The PARTITION BY clause is followed by the column or expression on which the partitioning should be based.
- You can specify multiple columns or expressions separated by commas to create multiple levels of partitioning.
- The column or expression used in the PARTITION BY clause does not have to be included in the SELECT statement.
- The PARTITION BY clause is typically used with aggregate functions like SUM, COUNT, AVG, etc., to calculate the result for each partition.

Here's an example of using the PARTITION BY clause with the SUM function:

```sql
SELECT category, product, sales, 
       SUM(sales) OVER (PARTITION BY category) AS category_sales
FROM sales_data;
```

In this example, the result set is partitioned by the "category" column. The SUM function is then applied to each partition separately, calculating the total sales within each category.

Here are some additional resources for learning more about the PARTITION BY clause:

- [SQL Tutorial - PARTITION BY Clause](https://www.sqltutorial.org/sql-window-functions/sql-partition-by/)
- [SQLShack - SQL PARTITION BY Clause Overview](https://www.sqlshack.com/sql-partition-by-clause-overview/)
- [LearnSQL - How to Use the PARTITION BY Clause in SQL](https://learnsql.com/blog/sql-partition-by-clause/)
- [Microsoft Docs - SELECT - OVER Clause (Transact-SQL)](https://docs.microsoft.com/en-us/sql/t-sql/queries/select-over-clause-transact-sql?view=sql-server-ver16)


...
