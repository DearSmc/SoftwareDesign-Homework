package com.solid.lsp;

public class Square extends Rectangle {

    private int side;
    Square(int side) {
        this.setSide(side);
    }

    public void setSide(int side) {
    	this.side = side;
        super.setWidth(side);
        super.setHeight(side);
    }
    public int getSide() {
        return side;
    }
}
