-- a. Retorna os nomes de todos os vendedores que não têm nenhum pedido com a empresa Samsonic
SELECT s.Name
FROM Salesperson s
WHERE s.ID NOT IN (
    SELECT o.salesperson_id
    FROM Orders o
    JOIN Customer c ON o.customer_id = c.ID
    WHERE c.Name = 'Samsonic'
);

-- b. Atualiza os nomes dos vendedores que têm 2 ou mais pedidos, adicionando '*' ao final do nome
UPDATE Salesperson
SET Name = CONCAT(Name, '*')
WHERE ID IN (
    SELECT salesperson_id
    FROM Orders
    GROUP BY salesperson_id
    HAVING COUNT(*) >= 2
);

-- c. Deleta todos os vendedores que fizeram pedidos para a cidade de Jackson
DELETE FROM Salesperson
WHERE ID IN (
    SELECT DISTINCT o.salesperson_id
    FROM Orders o
    JOIN Customer c ON o.customer_id = c.ID
    WHERE c.City = 'Jackson'
);

-- d. Mostra o total de vendas para cada vendedor, exibindo zero para quem não vendeu nada
SELECT s.Name, COALESCE(SUM(o.Amount), 0) AS total_sales
FROM Salesperson s
LEFT JOIN Orders o ON s.ID = o.salesperson_id
GROUP BY s.Name;
