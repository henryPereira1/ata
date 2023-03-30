package br.edu.univille.estd;

public class ArranjoPosicaoInvalidaException extends RuntimeException{
    public ArranjoPosicaoInvalidaException(int quantidade, int posicao){
        super("Posição "+posicao+" inválida. Arranjo com "+quantidade+" elementos.");
    }
}
