package utils;

public class Constants {
    public static class Directions{
        public static final int LEFT =0;
        public static final int UP =1;
        public static final int RIGHT =2;
        public static final int DOWN =3;

    }
    public static class PlayerConstants {
        public static final int IDLE = 1;
        public static final int RUNNING = 0;
        public static final int JUMP = 2;
        public static final int ATTACK = 3;
        public static final int DEFEND =4;
        public static final int HIT = 5;
        public static final int DIED = 6;
        public static final int SPECIAL_ATTACK = 7;

        public static int GetSpriteAmount(int player_action) {
            switch (player_action) {
                case DEFEND:
                case ATTACK:
                case IDLE:
                    return 4;
                case DIED:
                    return 5;
                case HIT:
                case JUMP:
                    return 3;
                case RUNNING:
                case SPECIAL_ATTACK:
                    return 6;
                default:
                    return 1;
            }
        }
    }
}
