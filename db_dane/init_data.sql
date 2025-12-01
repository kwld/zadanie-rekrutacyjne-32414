-- Uzupełnianie tabeli AUTOR
-- UWAGA: id jest automatycznie generowane (IDENTITY/SERIAL)

INSERT INTO autor (imie, nazwisko) VALUES
('Andrzej', 'Sapkowski'),         -- ID 1
('Joanna', 'Bator'),              -- ID 2
('George', 'Orwell'),             -- ID 3
('Olga', 'Tokarczuk');            -- ID 4

-- Uzupełnianie tabeli KSIAZKA
-- kolumna: autor_id musi odnosić się do ID z tabeli autor

INSERT INTO ksiazka (tytul, rok_wydania, isbn, autor_id) VALUES
-- Książki Andrzeja Sapkowskiego (ID 1)
('Ostatnie życzenie', 1993, '978-8375780662', 1),
('Miecz Przeznaczenia', 1992, '978-8375780655', 1),

-- Książki Joanny Bator (ID 2)
('Ciemno, prawie noc', 2012, '978-8324729090', 2),

-- Książki George''a Orwella (ID 3)
('Rok 1984', 1949, '978-8375105221', 3),
('Folwark zwierzęcy', 1945, '978-8375103449', 3),

-- Książki Olgi Tokarczuk (ID 4)
('Bieguni', 2007, '978-8308051785', 4),
('Księgi Jakubowe', 2014, '978-8308049317', 4);

-- KROK 1: Uzupełnianie tabeli AUTOR (dodano nowych autorów)
-- UWAGA: id jest automatycznie generowane (IDENTITY/SERIAL)

INSERT INTO autor (imie, nazwisko) VALUES
('Andrzej', 'Sapkowski'),         -- ID 1
('Joanna', 'Bator'),              -- ID 2
('George', 'Orwell'),             -- ID 3
('Olga', 'Tokarczuk'),            -- ID 4
('Stephen', 'King'),              -- ID 5
('J.R.R.', 'Tolkien'),            -- ID 6
('Wisława', 'Szymborska'),        -- ID 7
('Remigiusz', 'Mróz'),            -- ID 8
('Jane', 'Austen');               -- ID 9

-- KROK 2: Uzupełnianie tabeli KSIAZKA (znacznie więcej rekordów)
-- kolumna: autor_id musi odnosić się do ID z tabeli autor

INSERT INTO ksiazka (tytul, rokWydania, isbn, autor_id) VALUES

-- Autor 1: Andrzej Sapkowski
('Ostatnie życzenie', 1993, '978-8375780662', 1),
('Miecz Przeznaczenia', 1992, '978-8375780655', 1),
('Krew Elfów', 1994, '978-8375780679', 1),
('Czas Pogardy', 1995, '978-8375780686', 1),
('Chrzest Ognia', 1996, '978-8375780693', 1),
('Pani Jeziora', 1999, '978-8375780716', 1),

-- Autor 2: Joanna Bator
('Ciemno, prawie noc', 2012, '978-8324729090', 2),
('Piaskowa Góra', 2009, '978-8374148450', 2),

-- Autor 3: George Orwell
('Rok 1984', 1949, '978-8375105221', 3),
('Folwark zwierzęcy', 1945, '978-8375103449', 3),
('Birmańskie dni', 1934, '978-8374955747', 3),

-- Autor 4: Olga Tokarczuk
('Bieguni', 2007, '978-8308051785', 4),
('Księgi Jakubowe', 2014, '978-8308049317', 4),
('Prowadź swój pług przez kości umarłych', 2009, '978-8308061159', 4),
('Dom dzienny, dom nocny', 1998, '978-8308070960', 4),

-- Autor 5: Stephen King
('Mroczna Wieża I: Roland', 1982, '978-8380970634', 5),
('Lśnienie', 1977, '978-8380971037', 5),
('Zielona Mila', 1996, '978-8381254381', 5),
('Carrie', 1974, '978-8381254251', 5),

-- Autor 6: J.R.R. Tolkien
('Hobbit, czyli tam i z powrotem', 1937, '978-8389241517', 6),
('Władca Pierścieni: Drużyna Pierścienia', 1954, '978-8389241104', 6),
('Silmarillion', 1977, '978-8389241241', 6),

-- Autor 7: Wisława Szymborska
('Wiersze wybrane', 2015, '978-8308056629', 7),
('Ludzie na moście', 1986, '978-8308053420', 7),

-- Autor 8: Remigiusz Mróz
('Kasacja (Joanna Chyłka #1)', 2015, '978-8379612347', 8),
('Zaginięcie (Joanna Chyłka #2)', 2015, '978-8379619872', 8),
('Oślepienie (Joanna Chyłka #6)', 2017, '978-8379618868', 8),

-- Autor 9: Jane Austen
('Duma i uprzedzenie', 1813, '978-8377797746', 9),
('Rozważna i romantyczna', 1811, '978-8377797708', 9);