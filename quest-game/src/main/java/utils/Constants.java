package utils;

public class Constants {
    public static class Directions{
        public static final int LEFT =0;
        public static final int UP =1;
        public static final int RIGHT =2;
        public static final int DOWN =3;

    }
    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK = 6;
        public static final int ATTACK_JUMP1 = 7;
        public static final int ATTACK_JUMP2 = 8;

        public static int GetSpriteAmount(int player_action) {
            switch (player_action) {
                case IDLE:
                case JUMP:
                case GROUND:
                case ATTACK:
                    return 4;
                case FALLING:
                    return 5;
                case ATTACK_JUMP1:
                    return 6;
                case ATTACK_JUMP2:
                case HIT:
                case RUNNING:
                    return 3;
                default:
                    return 1;
            }
        }
    }
}
