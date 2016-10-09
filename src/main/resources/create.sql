CREATE TABLE budgetsummary
(
    sum_id INTEGER PRIMARY KEY NOT NULL,
    sum_all NUMERIC,
    sum_eating NUMERIC,
    sum_leisure NUMERIC,
    sum_rent NUMERIC,
    sum_transport INTEGER
);
CREATE UNIQUE INDEX budgetsummary_sum_id_uindex ON budgetsummary (sum_id);






CREATE TABLE lineitems
(
    li_id INTEGER PRIMARY KEY NOT NULL,
    li_des VARCHAR(500),
    li_cat VARCHAR(500),
    li_budam NUMERIC,
    li_actam NUMERIC
);
CREATE UNIQUE INDEX lineitems_li_id_uindex ON lineitems (li_id);