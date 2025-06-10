/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controle;

import java.sql.SQLException;

/**
 *
 * @author anton
 */
public class TesteCon {
     public static void main(String[] args) throws SQLException {
       DAO con = new DAO();
       con.abrirBanco();
    }
    
    
}
