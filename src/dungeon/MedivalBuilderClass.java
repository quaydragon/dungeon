package dungeon;



import dungeon.Level;
import dungeon.LevelHardness;
import dungeon.Monster;
import dungeon.Treasure;


public class MedivalBuilderClass implements MedivalBuilder {
  private int levelNumber;
  private int roomLimit;
  private int monstersNumber;
  private int treasuresNumber;
  private int roomCount;
  private int monsterCount;
  private int treasureCount;
  private boolean complete;
  private Level level;
  private LevelHardness hardness;
  
  /**
   * 
   * @param levelNumber
   * @param roomLimit
   * @param monstersNumber
   * @param treasuresNumber
   */
  public MedivalBuilderClass(int levelNumber,
      int roomLimit,
      int monstersNumber,
      int treasuresNumber) {
    this.levelNumber = levelNumber;
    this.roomLimit = roomLimit;
    this.monstersNumber = monstersNumber;
    this.treasuresNumber = treasuresNumber;
    
    this.roomCount = 0;
    this.monsterCount = 0;
    this.treasureCount = 0;
    this.complete = false;
    
    this.level = new Level(levelNumber);
    
    this.levelHardnessDetermination();
    
    
    //TODO: Throw exception because at certain levels 
    //we need a certain number of rooms
    
  }
  
  private void levelHardnessDetermination() {
   
    if (this.levelNumber <= 25) {
      this.hardness = LevelHardness.EASY;
    } else if (this.levelNumber <= 50) {
      this.hardness = LevelHardness.MEDIUM;
    } else if (this.levelNumber <= 75) {
      this.hardness = LevelHardness.HARD;
    } else if (this.levelNumber > 75) {
      this.hardness  = LevelHardness.IMPOSSIBLE;
    }
  }

  @Override
  public void addRoom() {
    // creating the number of rooms
    for (int i = 0; i < this.roomLimit + 1; i++) {
      level.addRoom("Room Number: " + i);
    }
    
  }
  
  
  @Override
  public void addGoblins() {
    
    System.out.println("Adding Goblins on: " + this.hardness);
    
    Monster goblin = new Monster("Goblin",
        "mischievous and very unpleasant, vengeful, and"
        + "greedy creature whose primary purpose is to"
            + "cause trouble to humankind",
        7);
    
    // Easy : all goblins
    // Other levels: take the left over rooms and monsters left 
    //fill with goblins
    
    if (this.hardness == LevelHardness.EASY) {
      
      //goblins per room  
      int goblinPerRoom = Math.floorDiv(this.monstersNumber, this.roomLimit);
      int leftOverGoblin = this.monstersNumber - goblinPerRoom * this.roomLimit;
      
      //TODO: May Delete
      //add up the monsters used- in easy these things should check out
      this.monsterCount = goblinPerRoom * this.roomLimit + leftOverGoblin;
       
      System.out.println("Number of Monsters: " + this.monstersNumber);
      System.out.println("Monsters Used: " + this.monsterCount);
      //go through each room
      for (int i = 0; i < this.roomLimit + 1; i++) {
        for (int j = 0; j < goblinPerRoom; j++) {
          level.addMonster(i, goblin);
        }
      }
      //add the remaining goblins to the first room
      for (int x = 0; x < leftOverGoblin; x++) {
        level.addMonster(0, goblin);
      }
    } else if (this.hardness == LevelHardness.MEDIUM) {
      //subtracting 1 for the orc room being reserved
      int goblinPerRoom = Math.floorDiv(this.monstersNumber - 1, this.roomLimit - 1);
      
      int goblinsRemaining = (this.monstersNumber - 1) 
          - (goblinPerRoom * (this.roomLimit - 1));
      
      System.out.println("For Medium Difficulty");
      System.out.println("Goblins Used: " + goblinPerRoom * (this.roomLimit - 1));
      
      for (int i = 0; i < this.roomLimit; i++) {
        for (int j = 0; j < goblinPerRoom; j++) {
          level.addMonster(i, goblin);
      
        }
        
      }
      
      System.out.println("Goblins Remaing to be used: " + goblinsRemaining);
      
      for (int x = 0; x < goblinsRemaining; x++) {
        level.addMonster(0, goblin);
      }
    } else if (this.hardness == LevelHardness.HARD) {
      
      int goblinPerRoom = Math.floorDiv(this.monstersNumber - 2, this.roomLimit - 2);
      
      System.out.println("GoblinPerRoom: " + goblinPerRoom);
      
      int goblinsRemaining = (this.monstersNumber - 2) 
          - (goblinPerRoom * (this.roomLimit - 2));
      
      System.out.println("For Hard Difficulty");
      System.out.println("Goblins Used: " + goblinPerRoom * (this.roomLimit - 2));
      
      for (int i = 0; i < this.roomLimit - 1; i++) {
        for (int j = 0; j < goblinPerRoom; j++) {
          level.addMonster(i, goblin);
      
        }
        
      }
      
      System.out.println("Goblins Remaing to be used: " + goblinsRemaining);
      
      for (int x = 0; x < goblinsRemaining; x++) {
        level.addMonster(0, goblin);
      }
      
    }
    

    
    
    
    
    
  }

  @Override
  public void addOrcs() {
    Monster orc = new Monster("Orc",
        "brutish, aggressive, malevolent being serving evil",
        20);
    if (this.hardness == LevelHardness.MEDIUM) {
      
      level.addMonster(this.roomLimit, orc);
    } else if (this.hardness == LevelHardness.HARD) {
      level.addMonster(this.roomLimit - 1, orc);
    }
  
    
    
  }

  @Override
  public void addOgre() {
    Monster ogre = new Monster("Ogre",
        "large, hideous man-like being that likes to eat humans for lunch",
        50);
    if (this.hardness == LevelHardness.HARD) {
      level.addMonster(this.roomLimit, ogre);
    } else if (this.hardness == LevelHardness.IMPOSSIBLE) {
      
      int ogrePerRoom = Math.floorDiv(this.monstersNumber, this.roomLimit);
      int leftOverOgre = this.monstersNumber - ogrePerRoom * this.roomLimit;
      
      //TODO: May Delete
      //add up the monsters used- in easy these things should check out
      this.monsterCount = ogrePerRoom * this.roomLimit + leftOverOgre;
       
      System.out.println("Number of Monsters: " + this.monstersNumber);
      System.out.println("Monsters Used: " + this.monsterCount);
      //go through each room
      for (int i = 0; i < this.roomLimit + 1; i++) {
        for (int j = 0; j < ogrePerRoom; j++) {
          level.addMonster(i, ogre);
        }
      }
      //add the remaining goblins to the first room
      for (int x = 0; x < leftOverOgre; x++) {
        level.addMonster(0, ogre);
      }
      
    }
    
    
  }

  @Override
  public void addHuman() {
    // Adds a human character to the first room
    Monster human = new Monster("Human",
        "Just your average Joe or Jane",
        0);
    level.addMonster(0, human);
    
  }

  @Override
  public void addPotion() {
    // split between all rooms but the last
    Treasure potion = new Treasure("a healing potion", 1);
    
    
    //    level.addTreasure(levelNumber, lightSaber);
    
    //get floor treasure divided by three 
    //distribute in each room 
    
    int treasurePerRoom = Math.floorDiv(this.treasuresNumber - 1, this.roomLimit - 1) / 3;
    //    int leftOverGoblin = this.monstersNumber - goblinPerRoom * this.roomLimit;
    
    System.out.println("Number of potion per room: " + treasurePerRoom);

    //go through each room
    for (int i = 0; i < this.roomLimit; i++) {
      for (int j = 0; j < treasurePerRoom; j++) {
        level.addTreasure(i, potion);
      }
    }
    
    this.treasureCount += treasurePerRoom * (this.roomLimit - 1);
    
    System.out.println("Treasure Count after potion");
    
    System.out.println(this.treasureCount);
    
  }

  @Override
  public void addGold() {
    // split between all rooms but the last
    Treasure gold;
    
    
    //    level.addTreasure(levelNumber, lightSaber);
    
    //get floor treasure divided by three 
    //distribute in each room 
    
    int treasurePerRoom = Math.floorDiv(this.treasuresNumber - 1, this.roomLimit - 1) / 3;
    //    int leftOverGoblin = this.monstersNumber - goblinPerRoom * this.roomLimit;
    
    System.out.println("Number of gold treasures per room: " + treasurePerRoom);

    //go through each room
    for (int i = 0; i < this.roomLimit; i++) {
      for (int j = 0; j < treasurePerRoom; j++) {
        //specified value of gold for room
        gold = new Treasure("gold", i + 1);
        level.addTreasure(i, gold);
      }
    }
    
    this.treasureCount += treasurePerRoom * (this.roomLimit - 1);
    
    System.out.println("Treasure Count after gold");
    
    System.out.println(this.treasureCount);
    
  }

  @Override
  public void addWeapon() {
    // split between all rooms but the last
    Treasure lightSaber = new Treasure("Ligh Saber Weapon", 10);
    
    
    //    level.addTreasure(levelNumber, lightSaber);
    
    //get floor treasure divided by three 
    //distribute in each room 
    
    int treasurePerRoom = Math.floorDiv(this.treasuresNumber - 1, this.roomLimit - 1) / 3;
    //    int leftOverGoblin = this.monstersNumber - goblinPerRoom * this.roomLimit;
    
    System.out.println("Number of weapons per room: " + treasurePerRoom);

    //go through each room
    for (int i = 0; i < this.roomLimit; i++) {
      for (int j = 0; j < treasurePerRoom; j++) {
        level.addTreasure(i, lightSaber);
      }
    }
    
    this.treasureCount += treasurePerRoom * (this.roomLimit - 1);
    
    System.out.println("Treasure Count after weapon");
    
    System.out.println(this.treasureCount);
    
  }

  @Override
  public void addSpecial() {
    Treasure exclusiveTreasure = new Treasure("Atomic Ray Gun", 100);
    level.addTreasure(roomLimit, exclusiveTreasure);
    this.treasureCount += 1;
    
    System.out.println("Treasure Count after special");
    
    System.out.println(this.treasureCount);
    
  }
  
  @Override
  public void checkForLeftOverTreasure() {
    
    Treasure gold = new Treasure("gold", 1);
    
    if (this.treasureCount < this.treasuresNumber) {
      int difference = this.treasuresNumber - this.treasureCount;
      System.out.println("This is the left over treasure: " + difference);
      for (int i = 0; i < difference; i++) {
        level.addTreasure(0, gold);
      }
    }
    
  }

  @Override
  public Level build() {
    this.addRoom();
    this.addGoblins();
    this.addOrcs();
    this.addOgre();
    this.addPotion();
    this.addGold();
    this.addWeapon();
    this.addSpecial();
    this.checkForLeftOverTreasure();
    
    System.out.print(level.toString());
    
    return level;
  }
}
