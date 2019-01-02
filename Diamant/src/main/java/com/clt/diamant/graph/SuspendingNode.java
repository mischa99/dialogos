/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clt.diamant.graph;

import com.clt.diamant.ExecutionLogger;
import com.clt.diamant.InputCenter;
import com.clt.diamant.WozInterface;
import com.clt.diamant.graph.nodes.DialogSuspendedException;

/**
 *
 * @author koller
 */
public abstract class SuspendingNode<E> extends Node {
    private E inputValue = null;
    
    
    @Override
    abstract public Node execute(WozInterface comm, InputCenter input, ExecutionLogger logger) throws DialogSuspendedException;
    
    public void resume(E inputValue) {
        this.inputValue = inputValue;
    }
    
    protected E consumeInputValue() {
        E ret = inputValue;
        inputValue = null;
        return ret;
    }
    
    protected void suspend() {
        getGraph().suspend(this);
    }
}