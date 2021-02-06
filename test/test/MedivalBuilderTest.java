package test;

import static org.junit.Assert.assertEquals;

import dungeon.MedivalBuilderClass;
import org.junit.Before;
import org.junit.Test;

public class MedivalBuilderTest {
  public MedivalBuilderClass easy;
  public MedivalBuilderClass medium;
  public MedivalBuilderClass hard;
  public MedivalBuilderClass impossible;
  
  /**
   * Sets up the MedivalBuilderClass for tests. 
   * 
   * @throws Exception if not constructed properly
   */
  @Before
  public void setUp() throws Exception {
    easy = new MedivalBuilderClass(25, 4, 10, 75);
    medium = new MedivalBuilderClass(50, 4, 10, 4);
    hard = new MedivalBuilderClass(75, 4, 12, 4);
    impossible = new MedivalBuilderClass(100, 4, 10, 4);
    
  }

  @Test
  public void testAddRoom() {
    easy.addRoom();
  }
  
  @Test
  public void testAddGoblinsEasy() {
    easy.addRoom();
    easy.addGoblins();
  }
  
  @Test
  public void testAddGoblinsMedium() {
    medium.addRoom();
    medium.addGoblins();
  }
  
  @Test
  public void testAddGoblinsHard() {
    hard.addRoom();
    hard.addGoblins();
  }
  
  @Test
  public void testAddOrcHard() {
    hard.addRoom();
    hard.addOrcs();
  }
  
  @Test
  public void testAddOgreImpossible() {
    impossible.addRoom();
    impossible.addOgre();
  }
  
  @Test
  public void testAddOgreHard() {
    hard.addRoom();
    hard.addOgre();
  }
  
  @Test
  public void testSpecial() {
    easy.addRoom();
    easy.addSpecial();
  }
  
  @Test
  public void testWeapon() {
    easy.addRoom();
    easy.addWeapon();
  }
  
  @Test
  public void testGold() {
    easy.addRoom();
    easy.addGold();
  }
  
  @Test
  public void testPotion() {
    easy.addRoom();
    easy.addPotion();
  }
  
  @Test
  public void testAddHuman() {
    easy.addRoom();
    easy.addHuman();
  }
  
  
  @Test
  public void testLeftOverTreasure() {
    easy.addRoom();
    easy.addSpecial();
    easy.addWeapon();
    easy.addGold();
    easy.addPotion();
    easy.checkForLeftOverTreasure();
  }
  
  @Test
  public void testBuild() {
    MedivalBuilderClass med = new MedivalBuilderClass(50, 4, 10, 75);
    
    med.build();
    
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorLevel() {
    new MedivalBuilderClass(-50, 4, 10, 75);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorRoom() {
    new MedivalBuilderClass(50, 1, 10, 75);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorMonsters() {
    new MedivalBuilderClass(50, 4, -10, 75);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTreasure() {
    new MedivalBuilderClass(50, 4, 10, -75);
  }


}
