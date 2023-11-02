INSERT INTO stadium(name, location, created_at)
VALUES ('잠실야구장', '서울 송파구 올림픽로 19-2 서울종합운동장', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('KT위즈파크', '경기 수원시 장안구 경수대로893 수원종합운동장', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('SSG 랜더스필드', '인천 미추홀구 매소홀로 618', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('NC파크', '경남 창원시 마산회원구 삼호로 63', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('기아챔피언스필드', '광주 북구 서림로 10 무등종합경기장', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('사직야구장', '부산 동래구 사직로 45', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('삼성라이온즈파크', '대구 수성구 야구전설로 1 대구삼성라이온즈파크', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('한화생명이글스파크', '대전 중구 대종로 373', CURRENT_TIMESTAMP);
INSERT INTO stadium(name, location, created_at)
VALUES ('고척스카이돔', '서울 구로구 경인로 430 고척스카이돔', CURRENT_TIMESTAMP);

INSERT INTO team(name, stadium_id, created_at)
VALUES ('LG 트윈스', 1, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('KT 위즈', 2, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('SSG 랜더스', 3, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('NC 다이노스', 4, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('두산 베어스', 1, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('KIA 타이거즈', 5, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('롯데 자이언츠', 6, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('삼성 라이온즈', 7, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('한화 이글스', 8, CURRENT_TIMESTAMP);
INSERT INTO team(name, stadium_id, created_at)
VALUES ('키움 히어로즈', 9, CURRENT_TIMESTAMP);

INSERT INTO game(match_date_time, home_team_id, away_team_id, status, created_at)
VALUES ('2023-10-31T15:30:00.000Z', 5, 9, 'READY', CURRENT_TIMESTAMP);


INSERT
INTO member(username, password, nickname, team_id, created_at)
values ('seonghye0n', 'test11', '한화짱', 9, CURRENT_TIMESTAMP);

INSERT INTO member(username, password, nickname, team_id, created_at)
values ('test1', 'test11', '노노두산짱', 5, CURRENT_TIMESTAMP);