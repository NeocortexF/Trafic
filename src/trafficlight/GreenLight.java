/*
 * Зеленый сигнал светофора
 */
package trafficlight;

import javax.swing.ImageIcon;

/**
 *
 * @author NeocortexF
 */
public class GreenLight extends Lamp {

    @Override
    ImageIcon getLampColor() {
        ImageIcon iconGreen = new ImageIcon(getClass().getResource("/trafficlight/Images/green.png"));
        return iconGreen;
    }
    
}
