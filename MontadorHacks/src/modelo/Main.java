/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;

/**
 *
 * @author Rafael
 */
public class Main {

    public static void main(String[] args) { // metodo main para teste

        Leitura leitor = new Leitura();

        try {
            leitor.lerEntrada("input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Não tem arquivo ...");
        }

        RegMem exec = new RegMem();

        exec.setPc(0); //zerando o Pc
        while (exec.getMemROM(exec.getPc()) != null) { //while (memRom[pc] != null)
            System.out.println(exec.getMemROM());
            leitor.romToDecod(exec.getMemROM(exec.getPc())); //romToDecod (memRom[pc]) ou seja mandando cada instrução da rom pra decodificação
            System.out.println("Comp: " + leitor.operacao() + "\nDestino: " + leitor.destino() + "\nJump: " + leitor.jump() + "\n");
            
            if (leitor.getIncrementaPC() == true) { //Se não tiver jump então
                exec.setPc(exec.getPc() + 1); //Pc++ 
            } else { //senão
                exec.setPc(exec.getRegA()); //Pc recebe RegA
            }

            leitor.setIncrementaPC(true);
        }
        System.out.println("Program Count: " + exec.getPc());

        System.out.println("\nImprimindo:");
        System.out.println("Registrador D: " + exec.getRegD());
        System.out.println("Registrador A: " + exec.getRegA());
        System.out.println("Memória[" + 0 + "]: " + exec.getMemDados(0));
        System.out.println("Memória[" + 1 + "]: " + exec.getMemDados(1));
        System.out.println("Memória[" + 2 + "]: " + exec.getMemDados(2));
        System.out.println("Memória[" + 3 + "]: " + exec.getMemDados(3));
        System.out.println("Memória[" + 4 + "]: " + exec.getMemDados(4));
    }
}
