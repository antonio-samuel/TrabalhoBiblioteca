
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11/06/2025 às 02:00
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `biblioteca`
--

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_livros_completo` ()   BEGIN
    SELECT 
        l.id,
        l.titulo,
        l.sinopse,
        l.valor,
        c.nome AS nomeCategoria,
        a.nome AS nomeAutor
    FROM livro l
    JOIN categoria c ON l.idCategoria = c.id
    JOIN autor a ON l.idAutor = a.id;
END$$

--
-- Funções
--
CREATE DEFINER=`root`@`localhost` FUNCTION `listar_livros_completo` () RETURNS TEXT CHARSET utf8mb4 COLLATE utf8mb4_general_ci DETERMINISTIC BEGIN
    DECLARE resultado TEXT DEFAULT '';
    DECLARE linha TEXT;
    
    -- Cursores
    DECLARE done INT DEFAULT FALSE;
    DECLARE cur CURSOR FOR
        SELECT 
            l.titulo,
            a.nome AS autor,
            c.nome AS categoria,
            l.valor
        FROM livro l
        JOIN autor a ON l.idAutor = a.id
        JOIN categoria c ON l.idCategoria = c.id;
        
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO linha;
        IF done THEN 
            LEAVE read_loop;
        END IF;
        SET resultado = CONCAT(resultado, linha, '\n');
    END LOOP;

    CLOSE cur;
    
    RETURN resultado;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `autor`
--

CREATE TABLE `autor` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `autor`
--

INSERT INTO `autor` (`id`, `nome`) VALUES
(1, 'Machado de Assis'),
(2, 'Isaac Asimov'),
(3, 'Jane Austen'),
(4, 'Steve Jobs'),
(5, 'Elon Musk'),
(6, 'J.K. Rowling'),
(7, 'Isaac Asimov'),
(8, 'Jane Austen'),
(9, 'Steve Jobs'),
(10, 'Elon Musk'),
(11, 'J.K. Rowling'),
(12, 'Isaac Asimov'),
(13, 'Jane Austen'),
(14, 'Steve Jobs'),
(15, 'Elon Musk'),
(16, 'J.K. Rowling');

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'Realista'),
(2, 'Ficção Científica'),
(3, 'Romance'),
(4, 'Biografia'),
(5, 'Tecnologia'),
(6, 'Fantasia'),
(7, 'Ficção Científica'),
(8, 'Romance'),
(9, 'Biografia'),
(10, 'Tecnologia'),
(11, 'Fantasia'),
(12, 'Ficção Científica'),
(13, 'Romance'),
(14, 'Biografia'),
(15, 'Tecnologia'),
(16, 'Fantasia');

-- --------------------------------------------------------

--
-- Estrutura para tabela `livro`
--

CREATE TABLE `livro` (
  `id` int(11) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `sinopse` char(200) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `Autor_livro` char(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `livro`
--

INSERT INTO `livro` (`id`, `titulo`, `sinopse`, `id_categoria`, `id_autor`, `valor`, `Autor_livro`) VALUES
(1, 'O alienista', 'narra a história do Dr. Simão Bacamarte, um médico que funda um hospício chamado Casa Verde na vila de Itaguaí', 1, 1, 100.00, NULL),
(2, 'Fundação', 'Clássico da ficção científica sobre um império galáctico.', 1, 1, 59.90, NULL),
(3, 'Orgulho e Preconceito', 'Romance entre Elizabeth Bennet e Mr. Darcy.', 2, 2, 39.90, NULL),
(4, 'A Biografia de Steve Jobs', 'História do fundador da Apple.', 3, 3, 49.90, NULL),
(5, 'O Futuro de Marte', 'Visão de Elon Musk sobre colonização espacial.', 1, 4, 42.00, NULL),
(6, 'Harry Potter e a Pedra Filosofal', 'Um menino descobre que é um bruxo.', 5, 5, 69.90, NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_autor` (`id_autor`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `autor`
--
ALTER TABLE `autor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `livro`
--
ALTER TABLE `livro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `livro`
--
ALTER TABLE `livro`
  ADD CONSTRAINT `livro_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `livro_ibfk_2` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
