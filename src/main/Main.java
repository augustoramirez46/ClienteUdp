package main;

import java.io.IOException;

import processing.core.PApplet;

public class Main extends PApplet{
	private int px;
	private int py;
	private int rad;
	
	private ClienteUdp g;
	

	public static void main(String[] args) {
		PApplet.main("main.Main");
		// TODO Auto-generated method stub

	}

	public void settings() {
		size(500, 500);
		
	}
	
	public void setup() {
		this.px = width/2;
		this.py = height/2;
		this.rad = 15;
		this.g = new ClienteUdp();
		
	}
	
	public void draw () {
		background(0);
		ellipse(this.px, this.py, this.rad, this.rad);
		
	}
	
	
	public void keyPressed() {
		
		  if (keyCode == 39) {
		    this.px ++;
		    try {
				g.enviado(String.valueOf(this.px));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  } else {
		    this.px --;
		    try {
				g.enviado(String.valueOf(this.px));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
	
	
	
}
