-- 1. 고령자
INSERT INTO users (name, address, birth, type)
VALUES ('박어르신', '서울시 종로구', '1945-08-15', 'SENIOR');

-- 2. 외국인
INSERT INTO users (name, address, birth, type)
VALUES ('Smith', 'Seoul, Yongsan', '1995-12-25', 'FOREIGNER');

-- 3. 발달 장애인
INSERT INTO users (name, address, birth, type)
VALUES ('김철수', '경기도 수원시', '2005-03-20', 'DEVELOPMENTAL');

-- 4. 청각 장애인
INSERT INTO users (name, address, birth, type)
VALUES ('이영희', '부산시 해운대구', '1992-07-07', 'HEARING');

-- 5. 시각 장애인
INSERT INTO users (name, address, birth, type)
VALUES ('최밝음', 'homeless', '1988-11-11', 'VISUAL');

-- 6. 일반인
INSERT INTO users (name, address, birth, type)
VALUES ('정평범', '인천시 연수구', '1998-05-05', 'NORMAL');