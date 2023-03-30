package br.edu.univille.estd;

import java.util.Arrays;

public class Arranjo {

    private int a[];

    private int capacidade;

    private int quantidade;

    public Arranjo(int capacidade){
        this.a = new int[capacidade];
        this.capacidade = capacidade;
    }

    public void adicionar(int elemento)throws ArranjoCheioException {
        if(quantidade < capacidade){
            this.a[this.quantidade++] = elemento;
            this.capacidade--;
        }else{
            throw new ArranjoCheioException(capacidade);
        }

    }

    public void adicionar(int posicao, int elemento)  throws  ArranjoCheioException, ArranjoPosicaoInvalidaException{
        if(!this.estaCheio()) {
            if(posicao >= 0 && posicao < this.a.length){
                this.a[posicao] = elemento;
                this.capacidade--;
                this.quantidade++;
            }else{
                throw new ArranjoPosicaoInvalidaException(quantidade, posicao);
            }
        }else{
            throw new ArranjoCheioException(capacidade);
        }
    }

    public int remover() throws ArranjoVazioException{
        return Integer.MAX_VALUE;
    }

    public int remover(int posicao)  throws ArranjoPosicaoInvalidaException{
        return Integer.MAX_VALUE;
    }

    public int obter(int posicao) throws ArranjoPosicaoInvalidaException{
        return this.a[posicao];
    }

    public int atualizar(int posicao, int elemento)  throws ArranjoPosicaoInvalidaException{
        return Integer.MAX_VALUE;
    }

    public int quantidade(){
        return this.quantidade;
    }

    public int capacidade(){
        return this.capacidade;
    }

    public boolean estaCheio(){
        return this.capacidade == 0 ? true : false;
    }
    public boolean estaVazio(){
        return this.capacidade == a.length ? true : false;
    }



}
