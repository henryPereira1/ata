package br.edu.univille.estd;

public class ArranjoCheioException extends RuntimeException{
    public ArranjoCheioException(int capacidade){
        super("O arranjo está cheio. Capacidade máxima de "+capacidade+" elementos.");
    }
}
