
CREATE TABLE IF NOT EXISTS `library` (
  `book_id` varchar(40) NOT NULL,
  `book_name` varchar(40) NOT NULL,
  `author` varchar(40) NOT NULL,
  `edition` varchar(20) NOT NULL,
  `issued_to` varchar(40) NOT NULL,
  `day` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL
);