package br.edu.univille.estd;

public class ArranjoVazioException extends RuntimeException{
    public ArranjoVazioException(){
        super("O arranjo está vazio.");
    }
}
