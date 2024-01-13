# Prueba QA - Johanna Montaño

## Pregunta # 1

![image](https://github.com/PatricaMontano/pruebat-tecnica-QA/assets/51218499/6ab8b5d0-8ac6-45ec-84f1-38aab1f5ed26)


Para resolver esta pregunta se realizo una consulta SQL

```sql
SELECT
    CONCAT(P.first_name, ' ', P.last_name) AS full_name,
    S.status_name
FROM
    Player AS P
JOIN
    Status AS S ON P.status_id = S.id
WHERE
    P.last_name LIKE 'U%'
ORDER BY
    full_name;
```

## Pregunta # 2

Para resolver esta pregunta se hicieron un conjunto de pruebas Automatizadas usando Selenium + JAVA
Este repositorio almacena todo este proyecto.

Se recomienda hacer uso de un IDE (Editor de Codigo) para facilitar la ejecución

- Intellij IDEA
- Netbeans

### Librerias Usadas
- Junit 4.13.2
- Selenium 4.16
