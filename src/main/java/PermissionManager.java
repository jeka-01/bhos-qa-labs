public class PermissionManager {
    enum PermissionLevel {
        ADMIN,
        DEVELOPER,
        USER
    }
    PermissionLevel mCurrentLevel = PermissionLevel.USER;
    public static String returnLevel(PermissionLevel level){
        return level.name();
    }

    public String setLevel(PermissionLevel level){
        level = this.mCurrentLevel;
        return level.name();
    }
}
