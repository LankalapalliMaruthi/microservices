CREATE TABLE IF NOT EXISTS Currency_Exchange (
    id BIGINT  PRIMARY KEY,
    from_currency VARCHAR(3) NOT NULL,
    to_currency VARCHAR(3) NOT NULL,
    conversion DECIMAL(10, 4) NOT NULL
);
