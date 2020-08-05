

package Touch_Control_DesktopApplication.Server1;

import java.awt.event.KeyEvent;
import java.security.Key;

public class VirtualKeyConverter {

    static public VirtualKey charToVirtualKey(int character){

        VirtualKey vk = new VirtualKey();
        if(vk.shiftIsOn!=true) {
            switch (character) {

                //-------------Char keys--------------------------------------------------
                case 59:
                    vk.VK = KeyEvent.VK_SHIFT;
                    vk.shiftIsOn = true;
                    break;

                case 70:
                    vk.VK = KeyEvent.VK_EQUALS;
                    break;
                case 74:
                    vk.VK = KeyEvent.VK_SEMICOLON;
                    break;
                case 55:
                    vk.VK = KeyEvent.VK_COMMA;
                    break;
                case 69:
                    vk.VK = KeyEvent.VK_MINUS;
                    break;
                case 56:
                    vk.VK = KeyEvent.VK_PERIOD;
                    break; //Bax Dot
                case 76:
                    vk.VK = KeyEvent.VK_SLASH;
                    break;

                case 7:
                    vk.VK = KeyEvent.VK_O;
                    break;
                case 8:
                    vk.VK = KeyEvent.VK_1;
                    break;
                case 9:
                    vk.VK = KeyEvent.VK_2;
                    break;
                case 10:
                    vk.VK = KeyEvent.VK_3;
                    break;
                case 11:
                    vk.VK = KeyEvent.VK_4;
                    break;
                case 12:
                    vk.VK = KeyEvent.VK_5;
                    break;
                case 13:
                    vk.VK = KeyEvent.VK_6;
                    break;
                case 14:
                    vk.VK = KeyEvent.VK_7;
                    break;
                case 15:
                    vk.VK = KeyEvent.VK_8;
                    break;
                case 16:
                    vk.VK = KeyEvent.VK_9;
                    break;

                case 71:
                    vk.VK = KeyEvent.VK_OPEN_BRACKET;
                    break;
                case 73:
                    vk.VK = KeyEvent.VK_BACK_SLASH;
                    break;
                case 72:
                    vk.VK = KeyEvent.VK_CLOSE_BRACKET;
                    break;
                case 68:
                    vk.VK = KeyEvent.VK_DEAD_GRAVE;
                    break; //Bax

                case 29:
                    vk.VK = KeyEvent.VK_A;
                    break;
                case 30:
                    vk.VK = KeyEvent.VK_B;
                    break;
                case 31:
                    vk.VK = KeyEvent.VK_C;
                    break;
                case 32:
                    vk.VK = KeyEvent.VK_D;
                    break;
                case 33:
                    vk.VK = KeyEvent.VK_E;
                    break;
                case 34:
                    vk.VK = KeyEvent.VK_F;
                    break;
                case 35:
                    vk.VK = KeyEvent.VK_G;
                    break;
                case 36:
                    vk.VK = KeyEvent.VK_H;
                    break;
                case 37:
                    vk.VK = KeyEvent.VK_I;
                    break;
                case 38:
                    vk.VK = KeyEvent.VK_J;
                    break;
                case 39:
                    vk.VK = KeyEvent.VK_K;
                    break;
                case 40:
                    vk.VK = KeyEvent.VK_L;
                    break;
                case 41:
                    vk.VK = KeyEvent.VK_M;
                    break;
                case 42:
                    vk.VK = KeyEvent.VK_N;
                    break;
                case 43:
                    vk.VK = KeyEvent.VK_O;
                    break;
                case 44:
                    vk.VK = KeyEvent.VK_P;
                    break;
                case 45:
                    vk.VK = KeyEvent.VK_Q;
                    break;
                case 46:
                    vk.VK = KeyEvent.VK_R;
                    break;
                case 47:
                    vk.VK = KeyEvent.VK_S;
                    break;
                case 48:
                    vk.VK = KeyEvent.VK_T;
                    break;
                case 49:
                    vk.VK = KeyEvent.VK_U;
                    break;
                case 50:
                    vk.VK = KeyEvent.VK_V;
                    break;
                case 51:
                    vk.VK = KeyEvent.VK_W;
                    break;
                case 52:
                    vk.VK = KeyEvent.VK_X;
                    break;
                case 53:
                    vk.VK = KeyEvent.VK_Y;
                    break;
                case 54:
                    vk.VK = KeyEvent.VK_Z;
                    break;


                //-------------Non char keys--------------------------------------------------
                case 67:
                    vk.VK = KeyEvent.VK_BACK_SPACE;
                    break;
                case 61:
                    vk.VK = KeyEvent.VK_TAB;
                    break;
                case 66:
                    vk.VK = KeyEvent.VK_ENTER;
                    break;
                case 113:
                    vk.VK = KeyEvent.VK_CONTROL;
                    break;
                case 57:
                    vk.VK = KeyEvent.VK_ALT;
                    break;
                case 121:
                    vk.VK = KeyEvent.VK_PAUSE;
                    break;
                case 115:
                    vk.VK = KeyEvent.VK_CAPS_LOCK;
                    break;
                case 111:
                    vk.VK = KeyEvent.VK_ESCAPE;
                    break;
                case 62:
                    vk.VK = KeyEvent.VK_SPACE;
                    break;
                case 92:
                    vk.VK = KeyEvent.VK_PAGE_UP;
                    break;
                case 93:
                    vk.VK = KeyEvent.VK_PAGE_DOWN;
                    break;
                case 123:
                    vk.VK = KeyEvent.VK_END;
                    break;
                case 122:
                    vk.VK = KeyEvent.VK_HOME;
                    break;
                case 21:
                    vk.VK = KeyEvent.VK_LEFT;
                    break;
                case 19:
                    vk.VK = KeyEvent.VK_UP;
                    break;
                case 22:
                    vk.VK = KeyEvent.VK_RIGHT;
                    break;
                case 20:
                    vk.VK = KeyEvent.VK_DOWN;
                    break;
                case 120:
                    vk.VK = KeyEvent.VK_PRINTSCREEN;
                    break;
                case 124:
                    vk.VK = KeyEvent.VK_INSERT;
                    break;
                case 112:
                    vk.VK = KeyEvent.VK_DELETE;
                    break;

                case 131:
                    vk.VK = KeyEvent.VK_F1;
                    break;
                case 132:
                    vk.VK = KeyEvent.VK_F2;
                    break;
                case 133:
                    vk.VK = KeyEvent.VK_F3;
                    break;
                case 134:
                    vk.VK = KeyEvent.VK_F4;
                    break;
                case 135:
                    vk.VK = KeyEvent.VK_F5;
                    break;
                case 136:
                    vk.VK = KeyEvent.VK_F6;
                    break;
                case 137:
                    vk.VK = KeyEvent.VK_F7;
                    break;
                case 138:
                    vk.VK = KeyEvent.VK_F8;
                    break;
                case 139:
                    vk.VK = KeyEvent.VK_F9;
                    break;
                case 140:
                    vk.VK = KeyEvent.VK_F10;
                    break;
                case 141:
                    vk.VK = KeyEvent.VK_F11;
                    break;
                case 142:
                    vk.VK = KeyEvent.VK_F12;
                    break;

                default:

                    vk.VK = 0;
                    break;
            }
        }
        else{
                switch (character) {
                    case 8:
                        vk.VK = KeyEvent.VK_1;
                        vk.shiftIsOn = true;
                        break;
                    case 75:
                        vk.VK = KeyEvent.VK_QUOTE;
                        vk.shiftIsOn = true;
                        break;
                    case 10:
                        vk.VK = KeyEvent.VK_3;
                        vk.shiftIsOn = true;
                        break;
                    case 11:
                        vk.VK = KeyEvent.VK_4;
                        vk.shiftIsOn = true;
                        break;
                    case 12:
                        vk.VK = KeyEvent.VK_5;
                        vk.shiftIsOn = true;
                        break;//Shiftle
                    case 14:
                        vk.VK = KeyEvent.VK_7;
                        vk.shiftIsOn = true;
                        break;
                    case 16:
                        vk.VK = KeyEvent.VK_9;
                        vk.shiftIsOn = true;
                        break;
                    case 7:
                        vk.VK = KeyEvent.VK_0;
                        vk.shiftIsOn = true;
                        break;
                    case 15:
                        vk.VK = KeyEvent.VK_8;
                        vk.shiftIsOn = true;
                        break;
                    case 70:
                        vk.VK = KeyEvent.VK_EQUALS;
                        vk.shiftIsOn = true;
                        break;
                    case 74:
                        vk.VK = KeyEvent.VK_SEMICOLON;
                        vk.shiftIsOn = true;
                        break;

                    case 55:
                        vk.VK = KeyEvent.VK_COMMA;
                        vk.shiftIsOn = true;
                        break;
                    case 56:
                        vk.VK = KeyEvent.VK_PERIOD;
                        vk.shiftIsOn = true;
                        break;
                    case 76:
                        vk.VK = KeyEvent.VK_SLASH;
                        vk.shiftIsOn = true;
                        break; //Shiftle
                    case 9:
                        vk.VK = KeyEvent.VK_2;
                        vk.shiftIsOn = true;
                        break;
                    case 29:
                        vk.VK = KeyEvent.VK_A;
                        vk.shiftIsOn = true;
                        break;
                    case 30:
                        vk.VK = KeyEvent.VK_B;
                        vk.shiftIsOn = true;
                        break;
                    case 31:
                        vk.VK = KeyEvent.VK_C;
                        vk.shiftIsOn = true;
                        break;
                    case 32:
                        vk.VK = KeyEvent.VK_D;
                        vk.shiftIsOn = true;
                        break;
                    case 33:
                        vk.VK = KeyEvent.VK_E;
                        vk.shiftIsOn = true;
                        break;
                    case 34:
                        vk.VK = KeyEvent.VK_F;
                        vk.shiftIsOn = true;
                        break;
                    case 35:
                        vk.VK = KeyEvent.VK_G;
                        vk.shiftIsOn = true;
                        break;
                    case 36:
                        vk.VK = KeyEvent.VK_H;
                        vk.shiftIsOn = true;
                        break;
                    case 37:
                        vk.VK = KeyEvent.VK_I;
                        vk.shiftIsOn = true;
                        break;
                    case 38:
                        vk.VK = KeyEvent.VK_J;
                        vk.shiftIsOn = true;
                        break;
                    case 39:
                        vk.VK = KeyEvent.VK_K;
                        vk.shiftIsOn = true;
                        break;
                    case 40:
                        vk.VK = KeyEvent.VK_L;
                        vk.shiftIsOn = true;
                        break;
                    case 41:
                        vk.VK = KeyEvent.VK_M;
                        vk.shiftIsOn = true;
                        break;
                    case 42:
                        vk.VK = KeyEvent.VK_N;
                        vk.shiftIsOn = true;
                        break;
                    case 43:
                        vk.VK = KeyEvent.VK_O;
                        vk.shiftIsOn = true;
                        break;
                    case 44:
                        vk.VK = KeyEvent.VK_P;
                        vk.shiftIsOn = true;
                        break;
                    case 45:
                        vk.VK = KeyEvent.VK_Q;
                        vk.shiftIsOn = true;
                        break;
                    case 46:
                        vk.VK = KeyEvent.VK_R;
                        vk.shiftIsOn = true;
                        break;
                    case 47:
                        vk.VK = KeyEvent.VK_S;
                        vk.shiftIsOn = true;
                        break;
                    case 48:
                        vk.VK = KeyEvent.VK_T;
                        vk.shiftIsOn = true;
                        break;
                    case 49:
                        vk.VK = KeyEvent.VK_U;
                        vk.shiftIsOn = true;
                        break;
                    case 50:
                        vk.VK = KeyEvent.VK_V;
                        vk.shiftIsOn = true;
                        break;
                    case 51:
                        vk.VK = KeyEvent.VK_W;
                        vk.shiftIsOn = true;
                        break;
                    case 52:
                        vk.VK = KeyEvent.VK_X;
                        vk.shiftIsOn = true;
                        break;
                    case 53:
                        vk.VK = KeyEvent.VK_Y;
                        vk.shiftIsOn = true;
                        break;
                    case 54:
                        vk.VK = KeyEvent.VK_Z;
                        vk.shiftIsOn = true;
                        break;
                    case 13:
                        vk.VK = KeyEvent.VK_6;
                        vk.shiftIsOn = true;
                        break;
                    case 69:
                        vk.VK = KeyEvent.VK_MINUS;
                        vk.shiftIsOn = true;
                        break;
                    case 71:
                        vk.VK = KeyEvent.VK_OPEN_BRACKET;
                        vk.shiftIsOn = true;
                        break; //Bax Shiftle
                    case 73:
                        vk.VK = KeyEvent.VK_BACK_SLASH;
                        vk.shiftIsOn = true;
                        break; //Bax Shiftle
                    case 72:
                        vk.VK = KeyEvent.VK_CLOSE_BRACKET;
                        vk.shiftIsOn = true;
                        break; //Bax Shiftle
                    case 68:
                        vk.VK = KeyEvent.VK_DEAD_GRAVE;
                        vk.shiftIsOn = true;
                        break; //Bax Shiftle
                    default:

                        vk.VK = 0;
                        break;
                }
        }
        return vk;
    }
}
