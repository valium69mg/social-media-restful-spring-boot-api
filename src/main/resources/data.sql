INSERT INTO "user"("id", "name", "birth_date")
VALUES 
(10001, 'Carlos', CURRENT_DATE()),
(10002, 'Tranquilino', CURRENT_DATE()),
(10003, 'Leonardo', CURRENT_DATE());

INSERT INTO "post" ("post_id","user_id","description")
VALUES 
(10001,10001, 'que rico taco!'),
(10002,10002, 'que rico burrito!'),
(10003,10003, 'que rico gerber!');
