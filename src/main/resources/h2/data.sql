-------------- GAME --------------
INSERT INTO game(home, away, status, created_at)
VALUES ('한화', 'NC', 'READY', CURRENT_TIMESTAMP);

INSERT INTO game(home, away, status, created_at)
VALUES ('삼성', '두산', 'PROCEEDING', CURRENT_TIMESTAMP);

-------------- MEMBER --------------
INSERT INTO member(username, password, nickname, created_at)
VALUES ('seonghye0n', 'test11', 'seonghye0n', CURRENT_TIMESTAMP);

INSERT INTO member(username, password, nickname, created_at)
VALUES ('test11', 'test11', '테스트', CURRENT_TIMESTAMP);