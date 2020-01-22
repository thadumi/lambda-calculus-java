package com.thadumi.talks.lambdacalculus;

import io.vavr.Function1;
import io.vavr.Function2;

@SuppressWarnings("ALL")
public interface LC {

    /*******************************************************************************************************************
     * COMBINATORS
     *
     * La logica combinatoria viene utilizzata come modello semplificato di calcolo.
     * Un combinator è una funzione senza variabli libere es. λx.x
     * Una variable, appartenente al corpo di una lambda, è libera quando essa non è confinata da un paramentro della
     * lambda stessa.
     */

    /**
     * Identity Function
     * λx.x
     */
    λ I =  x -> x;
    λ Idiot = I;

    λ M = f -> f.apply(f);
    λ Mockingbird = M;

    λ K = x -> y -> x;
    λ Kestrel = K;

    // x -> y -> y;
    λ KI = K.apply(I);
    λ Kite = KI;

    λ C = f -> x -> y -> f.apply(y).apply(x);
    λ Cardinal = C;
    λ flip = C;

    λ B = f -> g -> x -> f.apply(g.apply(x));
    λ Bluebird = B;

    // λ Th = x -> f -> f.apply(x);
    λ Th = C.apply(I);
    λ Thrush = Th;

    // λ V = x -> y -> f -> f.apply(x).apply(y);
    λ V = B.apply(C).apply(Th);
    λ Vireo = V;

    // λ B1 = f -> g -> x -> y -> f.apply(g.apply(x).apply(y));
    λ B1 = B.apply(B).apply(B);
    λ Blachbird = B1;

    /*******************************************************************************************************************
     * Boolean values as functions
     * True  := λxy.x
     * False := λxy.y
     */
    λ T = x -> y -> x;
    λ F = x -> y -> y;

    /*
    λ F = C.apply(T);
     Hm. How can "true" and "false" be functions?
    Well, the point of booleans is to _select_ between a then-case and an else-case.
    The LC booleans are just functions which do that!
    `T` takes two vals and returns the first;
    `F` takes two vals and returns the second.
    If you apply an unknown bool func to two vals, the first val will be returned if the bool was true,
    else the second val will be returned.
    */

    /**
     * λx.xFT
     */
    λ NOT = x -> x.apply(F).apply(T);

    /**
     * λxy.xyF
     */
    λ AND = x -> y -> x.apply(y).apply(F);

    /**
     * λxy.xTy
     */
    λ OR = x -> y -> x.apply(T).apply(y);

    /**
     * λxy.x (yTF) (yFT)
     */
    λ BEQ = x -> y -> x.apply(y.apply(T).apply(F)).apply(y.apply(F).apply(T));


    /*******************************************************************************************************************
     * Numbers
     */

    /**
     * ZERO
     * λfx.x
     */
    λ ZERO = f -> x -> x;

    λ ONE_HARDCODED = f -> x -> f.apply(x);

    λ TWO_HARDCODED = f -> x -> f.apply(f.apply(x));

    /**
     * SUCCESSOR := λnfx.f(nfx)
     */
    λ SUCCESSOR = n -> f -> x -> f.apply(n.apply(f).apply(x));

    λ ONE = SUCCESSOR.apply(ZERO);
    λ TWO = SUCCESSOR.apply(SUCCESSOR.apply(ZERO));

    λ isZero = n -> n.apply(K.apply(F)).apply(T);

    /*******************************************************************************************************************
     * Pairs
     */

    λ PAIR = V;

    λ FST = p -> p.apply(K);
    λ SND = p -> p.apply(KI);

    /*******************************************************************************************************************
     * List
     */

    // The first element of the pair is true meaning the list is null.
    λ NIL = PAIR.apply(T).apply(T);
    λ isNil = FST;

    // Create a list node, which is not null, and give it a head h and a tail t.
    λ CONS = head -> tail -> PAIR.apply(F).apply(PAIR.apply(head).apply(tail));
    // second.first is the head
    λ HEAD = list -> FST.apply(SND.apply(list));
    // second.second is the tail
    λ TAIL = list -> SND.apply(SND.apply(list));


    interface λ extends Function1<λ, λ> { }
}
