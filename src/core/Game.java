package core;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame implements KeyListener  {
	private JLabel comp1;
	private List<JLabel> quadros = new ArrayList<JLabel>();

    public Game() {
      setTitle("GG");
      setLayout(null);
      
      criaQuadrado(0, 0, 64, 64, "user.png");
      criaQuadrado(0, 0, 200, 200, "blade.gif");
      
      
      moveBlue();
      addKeyListener(this);
      setSize(800,500);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void criaQuadrado(Integer col, Integer lin, Integer lar, Integer alt, String file) {
    	JLabel label = new JLabel();
    	label.setBounds(col, lin, lar, alt); 
    	label.setVisible(true);
    	label.setIcon(new ImageIcon(getClass().getResource("/resource/"+file)));
    	quadros.add(label);
    	getContentPane().add(label);
    }

    
    
    
    
    
    
    //MOVE ENEMY BLUE
    private void moveBlue(){
		new Thread() {
			public void run() {
					try {
						for(;;){
							Random gerador = new Random();
							
							int limiteAltura = 800, limiteLargura = 500;
							
							int numero = gerador.nextInt(5);
							/*1 = SOBE
							* 2 = DESCE
							* 3 = ESQUERDO
							* 4 = DIREITO
							*/
							
							int numeroPausa = gerador.nextInt(5);
							int numeroRepeticoes = gerador.nextInt(5);
							int tempoPause = gerador.nextInt(100) + 0;
							int casasAvancar = 5;
							
							switch (numero) {
							case 1:
								for(int x = 0 ; x < numeroRepeticoes; x++){
									if(quadros.get(1).getLocation().getY() > casasAvancar){
										int px = gerador.nextInt(casasAvancar);
										quadros.get(1).setLocation(quadros.get(1).getX(), quadros.get(1).getY()-px);
										if(numeroPausa == numero){
											Thread.sleep(tempoPause);
										}
									}
								}
								break;
							case 2:
								for(int x = 0 ; x < numeroRepeticoes; x++){
									if(quadros.get(1).getLocation().getY() < limiteAltura-casasAvancar){
										int px = gerador.nextInt(casasAvancar);
										quadros.get(1).setLocation(quadros.get(1).getX(), quadros.get(1).getY()+px);
										if(numeroPausa == numero){
											Thread.sleep(tempoPause);
										}
									}
								}
								break;
							case 3:
								for(int x = 0 ; x < numeroRepeticoes; x++){
									if(quadros.get(1).getLocation().getX() > casasAvancar){
										int px = gerador.nextInt(casasAvancar);
										quadros.get(1).setLocation(quadros.get(1).getX()-px, quadros.get(1).getY());
										if(numeroPausa == numero){
											Thread.sleep(tempoPause);
										}
									}
								}
								break;
							case 4:
								for(int x = 0 ; x < numeroRepeticoes; x++){
									if(quadros.get(1).getLocation().getX() < limiteLargura-casasAvancar){
										int px = gerador.nextInt(casasAvancar);
										quadros.get(1).setLocation(quadros.get(1).getX()+px, quadros.get(1).getY());
										if(numeroPausa == numero){
											Thread.sleep(tempoPause);
										}
									}
								}
								break;
								

							default:
								break;
							}
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				
			}
		}.start();
	}
    
    
    
    
    
    // LISTENER DO TECLADO
    
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			quadros.get(0).setLocation(quadros.get(0).getX(), quadros.get(0).getY()+5);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			quadros.get(0).setLocation(quadros.get(0).getX(), quadros.get(0).getY()-5);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			quadros.get(0).setLocation(quadros.get(0).getX()-5, quadros.get(0).getY());
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			quadros.get(0).setLocation(quadros.get(0).getX()+5, quadros.get(0).getY());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

   
}

