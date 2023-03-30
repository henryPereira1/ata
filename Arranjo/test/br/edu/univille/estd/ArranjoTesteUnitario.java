package br.edu.univille.estd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ArranjoTesteUnitario {


    @Test
    void arranjoVazio(){
        Arranjo a = new Arranjo(10);
        assertEquals(10,a.capacidade(),"Capacidade do arranjo");
        assertEquals(0,a.quantidade(),"Quantidade de elementos no arranjo");
        assertFalse(a.estaCheio(),"O arranjo não deve estar cheio");
    }

    @Test
    void adicionarUmElemento(){
        Arranjo a = new Arranjo(10);
        a.adicionar(99);
        assertEquals(1,a.quantidade(),"Quantidade de elementos no arranjo");
    }

    @Test
    void adicionar10Elementos(){
        Arranjo a = new Arranjo(100);
        IntStream.range(10, 20).forEach(a::adicionar);
        assertEquals(10,a.quantidade(),"O arranjo deve ter 10 elementos.");
    }

    @Test
    void adicionarUmElementoEmUmArranjoCheio(){
        Arranjo a = new Arranjo(100);
        IntStream.range(10, 110).forEach(a::adicionar);
        try{
            a.adicionar(99);
            fail("Deve lançar a exceção ArranjoCheioException ao adicionar um elemento em um arranjo cheio.");
        }catch (ArranjoCheioException ignored){}
    }

    @Test
    void adicionarUmElementoNaPosicao(){
        Arranjo a = new Arranjo(30);
        IntStream.range(10, 20).forEach(a::adicionar);
        a.adicionar(5,8989);
        assertEquals(11,a.quantidade(),"O arranjo deve ter 11 elementos.");
        assertEquals(8989,a.obter(5),"O elemento da posição 5 deve ser o 11.");
        assertEquals(15,a.obter(6),"O elemento da posição 5 deve ser o 14.");
    }


    @Test
    void adicionarUmElementoPorPosicaoEmUmArranjoCheio(){
        Arranjo a = new Arranjo(100);
        IntStream.range(10, 110).forEach(a::adicionar);
        try{
            a.adicionar(4,99);
            fail("Deve lançar a exceção ArranjoCheioException ao adicionar um elemento por posicao em um arranjo cheio.");
        }catch (ArranjoCheioException ignored){}
    }




    @Test
    void obterUmElementoPelaPosicao(){
        Arranjo a = new Arranjo(10);
        a.adicionar(89);
        a.adicionar(99);
        a.adicionar(12);
        assertEquals(99, a.obter(1),"Deve retornar elemento 99 que está na posição Zero");
    }

    @Test
    void obterUmElementoComPosicaoInvalida(){
        Arranjo a = new Arranjo(10);
        a.adicionar(99);
        try{
            a.obter(1);
            fail("Deve lançar a exceção ArranjoPosicaoInvalidaException ao acessar uma posição inválida");
        }catch (ArranjoPosicaoInvalidaException ignored){}
    }

    @Test
    void arranjoCheioAteACapacidadeMaxima(){
        Arranjo a = new Arranjo(10);
        IntStream.range(0, 10).map(i -> 99).forEach(a::adicionar);
        assertTrue(a.estaCheio(),"O arranjo deve estar cheio até a capacidade máxima");
    }

    @Test
    void removerElemento(){
        Arranjo a = new Arranjo(5);
        IntStream.range(10,15).forEach(a::adicionar);
        assertEquals(14, a.remover(),"O elemento removido deve ser o 14.");
        assertEquals(4,a.quantidade(),"Quantidade de elementos no arranjo");
        assertFalse(a.estaCheio(),"O arranjo não deve estar cheio até a capacidade máxima");
    }


    @Test
    void removerElementoPeloIndice(){
        Arranjo a = new Arranjo(5);
        IntStream.range(10, 15).forEach(a::adicionar);
        assertEquals(12, a.remover(2),"O elemento removido deve ser o 12.");
        assertEquals(12, a.obter(2),"O elemento da posicao 2 deve ser o 13.");
        assertEquals(4,a.quantidade(),"Quantidade de elementos no arranjo");
        assertFalse(a.estaCheio(),"O arranjo não deve estar cheio até a capacidade máxima");
    }


    @Test
    void removerUmElementoComPosicaoInvalida(){
        Arranjo a = new Arranjo(5);
        IntStream.range(10, 15).forEach(a::adicionar);
        a.remover();
        try{
            a.remover(4);
            fail("Deve lançar a exceção ArranjoPosicaoInvalidaException ao remover um elemento com a posição inválida");
        }catch (ArranjoPosicaoInvalidaException ignored){}
    }


    @Test
    void removerElementosAteFicarVazio(){
        Arranjo a = new Arranjo(5);
        IntStream.range(0, 5).forEach(a::adicionar);
        a.remover();
        a.remover();
        a.remover();
        a.remover();
        a.remover();
        assertTrue(a.estaVazio(),"O arranjo deve estar vazio.");
    }


    @Test
    void removerElementoDeUmArranjoVazio(){
        Arranjo a = new Arranjo(5);
        IntStream.range(10,15).forEach(a::adicionar);
        a.remover();
        a.remover();
        a.remover();
        a.remover();
        a.remover();
        try{
            a.remover();
            fail("Deve lançar a exceção ArranjoVazioException ao remover um elemento de um arranjo vazio");
        }catch (ArranjoVazioException ignored){}

    }


    @Test
    void atualizarUmElementoNaPosicao(){
        Arranjo a = new Arranjo(30);
        IntStream.range(10, 30).forEach(a::adicionar);
        assertEquals(20,a.atualizar(10,99), "Deve retornar o elemento 20 que foi substituido na posição 10.");
        assertEquals(99,a.obter(10), "Deve retornar o novo elemento 99 que se encontra na posição 10.");
        assertEquals(20,a.quantidade(),"Quantidade de elementos no arranjo");
    }

    @Test
    void atualizarUmElementoComPosicaoInvalida(){
        Arranjo a = new Arranjo(5);
        IntStream.range(10, 15).forEach(a::adicionar);
        try{
            a.atualizar(10,4);
            fail("Deve lançar a exceção ArranjoPosicaoInvalidaException ao atualizar um elemento com a posição inválida");
        }catch (ArranjoPosicaoInvalidaException ignored){}
    }


}