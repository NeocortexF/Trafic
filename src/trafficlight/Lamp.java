/*
 * Класс фонарь. Родитель для красного, желтого, зеленого цветов ламп светофора
 */
package trafficlight;

import javax.swing.ImageIcon;

/**
 *
 * @author NeocortexF
 */
abstract class Lamp {
    
    abstract ImageIcon getLampColor();
    
}
