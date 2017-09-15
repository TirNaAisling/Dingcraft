package uk.co.yogadb.craftlab.dingcraft;

public class Reference {
    public static final String MOD_ID = "dingcraft";
    public static final String NAME = "Dingcraft!";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.11.2]";


    public static final String CLIENT_PROXY = "uk.co.yogadb.craftlab.dingcraft.proxy.ClientProxy";
    public static final String SERVER_PROXY = "uk.co.yogadb.craftlab.dingcraft.proxy.ServerProxy";

    // Player
    public static final float MIN_LEVEL = 1.0F;
    public static final float START_HEALTH = 2.0F;

    // Level ranges for player crafting attributes
    public static final int[][] WOOD_LEVEL = { {0, 9}, {10, 24}, {25, 49}, {50, 79} };
    //public static final int[][] WOOD_LEVEL = { {0, 99}, {100, 249}, {250, 499}, {500, 799} };
    public static final int[][] COOKING_LEVEL = { {0, 99}, {100, 249}, {250, 499}, {500, 799} };
    public static final int[][] FARMING_LEVEL = { {0, 99}, {100, 249}, {250, 499}, {500, 799} };
    public static final int[][] SMITHING_LEVEL = { {0, 99}, {100, 249}, {250, 499}, {500, 799} };
    public static final int[][] MINING_LEVEL = { {0, 99}, {100, 249}, {250, 499}, {500, 799} };

    /*
     Food Item enum definitions
     */
    public static enum DingcraftFoodItems{
        CHEESE("cheese", "item_cheese", 2),
        CHEESE_SLICE("cheese_slice", "item_cheese_slice", 2),
        CRACKER("cracker", "item_cracker", 1),
        CHEESE_CRACKER("cheese_cracker", "item_cheese_cracker", 3),
        STEAK_SANDWICH("steak_sandwich", "item_steak_sandwich", 4);

        private String unlocalizedName;
        private String registryName;
        private int craftLevel;

        DingcraftFoodItems(String unlocalizedName, String registryName, int craftLevel){
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
            this.craftLevel = craftLevel;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }

        public int getCraftLevel() {
            return craftLevel;
        }
    }

    /*
     Block enum definitions
     */
    public enum DingcraftBlocks{
        JAR("", "");

        private String unlocalizedName;
        private String registryName;

        DingcraftBlocks(String unlocalizedName, String registryName){
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }

    /*
     Tab enum definitions
     */
    public static enum DingcraftTabs{
        DINGCRAFT_FOOD_TAB("dingcraftFoodTab");

        private String unlocalizedName;

        DingcraftTabs(String unlocalizedName){
            this.unlocalizedName = unlocalizedName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }
    }
}
