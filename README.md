-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10/06/2025 às 16:54
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
(1, 'Machado de Assis');

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
(1, 'Realista');

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
(1, 'O alienista', 'narra a história do Dr. Simão Bacamarte, um médico que funda um hospício chamado Casa Verde na vila de Itaguaí', 1, 1, 100.00, NULL);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `livro`
--
ALTER TABLE `livro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
