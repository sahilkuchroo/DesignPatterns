/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication91;

/**
 *
 * @author NIIT
 */
public class javaapplication91 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODclass BridgePatternDemo {
   
      Shape redCircle = new Circle(100,100, 10, new RedCircle());
      Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

      redCircle.draw();
      greenCircle.draw();
    }
    
}
