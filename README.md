# GUI_DBlogs
fetch DB logs and display them on GUI

Database setup:
CREATE table "LOGGER" (
    "LOG_TYPE"       VARCHAR2(255),
    "LOG_SUBTYPE"    VARCHAR2(255),
    "LOG_DATETIME"   CLOB,
    "LOG_PAYLOAD"    VARCHAR2(25),
    "LOG_TXN_REF_NO" VARCHAR2(255)
)

Insert into LOGGER (LOG_TYPE,LOG_SUBTYPE,LOG_DATETIME,LOG_PAYLOAD, LOG_TXN_REF_NO) VALUES ('financial_transaction','Bill_payment',SYSTIMESTAMP,'<amount>100</amount>',123456);
Insert into LOGGER (LOG_TYPE,LOG_SUBTYPE,LOG_DATETIME,LOG_PAYLOAD, LOG_TXN_REF_NO) VALUES ('financial_transaction','Bill_payment',SYSTIMESTAMP,''<Details><amount>100</amount><name>khem</name></Details>'',123456);
Insert into LOGGER (LOG_TYPE,LOG_SUBTYPE,LOG_DATETIME,LOG_PAYLOAD, LOG_TXN_REF_NO) VALUES ('financial_transaction','Bill_payment',SYSTIMESTAMP,'<response>Success</response>',123456);

Change the username,password in db.properties file
