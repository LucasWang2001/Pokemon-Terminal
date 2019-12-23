import java.util.*;
import java.io.*;
import java.util.Random;


public class PokemonArena {
	
	private static Pokemon activePokemon, enemyPokemon;
	private static ArrayList<Pokemon> enemies = new ArrayList<Pokemon>();
	private static ArrayList<Pokemon> friends = new ArrayList<Pokemon>();
	private static ArrayList<Pokemon> deadEnemies = new ArrayList<Pokemon>();
	
	public void title(){
		Scanner stdin = new Scanner(System.in);
		System.out.println("  Welcome to....");
		System.out.println("                                                                                                                 ");
		System.out.println("   _¦¦¦¦¦¦_     _¦    ¦_       _¦¦¦¦¦¦¦¦     ¦¦¦         ¦¦¦      _¦¦¦¦¦¦_    ____¦¦¦____    _¦¦¦¦¦¦_  ¦¦¦____   ");
		System.out.println("  ¦¦¦    ¦¦¦   ¦¦¦    ¦¦¦     ¦¦¦    ¦¦¦ ¯¦¦¦¦¦¦¦¦¦_ ¯¦¦¦¦¦¦¦¦¦_ ¦¦¦    ¦¦¦ _¦¦¯¯¯¦¦¦¯¯¯¦¦_ ¦¦¦    ¦¦¦ ¦¦¦¯¯¯¦¦_ ");
		System.out.println("  ¦¦¦    ¦¯    ¦¦¦    ¦¦¦     ¦¦¦    ¦¯     ¯¦¦¦¯¯¦¦    ¯¦¦¦¯¯¦¦ ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦   ¦¦¦ ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦ ");
		System.out.println(" _¦¦¦         _¦¦¦____¦¦¦__  _¦¦¦___         ¦¦¦   ¯     ¦¦¦   ¯ ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦   ¦¦¦ ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦");
		System.out.println("¯¯¦¦¦ ¦¦¦¦_  ¯¯¦¦¦¯¯¯¯¦¦¦¯  ¯¯¦¦¦¯¯¯         ¦¦¦         ¦¦¦     ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦   ¦¦¦ ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦ ");
		System.out.println("  ¦¦¦    ¦¦¦   ¦¦¦    ¦¦¦     ¦¦¦    ¦_      ¦¦¦         ¦¦¦     ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦   ¦¦¦ ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦ ");
		System.out.println("  ¦¦¦    ¦¦¦   ¦¦¦    ¦¦¦     ¦¦¦    ¦¦¦     ¦¦¦         ¦¦¦     ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦   ¦¦¦ ¦¦¦    ¦¦¦ ¦¦¦   ¦¦¦ ");
		System.out.println("  ¦¦¦¦¦¦¦¦¯    ¦¦¦    ¦¯      ¦¦¦¦¦¦¦¦¦¦    _¦¦¦¦¯      _¦¦¦¦¯    ¯¦¦¦¦¦¦¯   ¯¦   ¦¦¦   ¦¯   ¯¦¦¦¦¦¦¯   ¯¦   ¦¯  ");
		System.out.println("                                                                                                                 ");
		System.out.println("Welcome to the amazing and fascinating, totally-not-a-copy-of-Pokemon, GhettoMon game!! Please enter your name:  ");
		String player=stdin.nextLine();
		System.out.println("Welcome "+player+". In this game, you will pick 4 GhettoMon's to be part of your team, and your goal is to kill &\nslaughter all the enemy GhettoMon, and only then, will you be the master trainer, only then will you win the game.");
		System.out.println("Now please select your team");
	}
	
	
	
	public static void read() throws IOException{
        Scanner stdin = new Scanner(System.in);

	    Scanner inFile =new Scanner(new BufferedReader(new FileReader("pokemon.txt")));
		int pokeNum = inFile.nextInt(); //the total number of available Pokemon in the file
		inFile.nextLine(); //skip to next line
		
	    while(inFile.hasNextLine()){
	    	String poke = inFile.nextLine();
	    	enemies.add(new Pokemon(poke));
	    }

		inFile.close();

	}
	
	public void DisplayTable(){
		System.out.println("==============================================================");
		System.out.println("--------------------------------------------------------------");
		for (int i=0; i<enemies.size()/3;i++){
			if (i==0){
				System.out.println(i+"."+(enemies.get(i)).name+"\t\t"+(i+7)+"."+(enemies.get(i+7)).name+"\t\t"+(i+14)+"."+(enemies.get(i+14)).name+"\t\t");
			}
			else if (i==2){
				System.out.println(i+"."+(enemies.get(i)).name+"\t\t"+(i+7)+"."+(enemies.get(i+7)).name+"\t\t\t"+(i+14)+"."+(enemies.get(i+14)).name+"\t\t");
			}
			else if (i==4){
				System.out.println(i+"."+(enemies.get(i)).name+"\t\t\t"+(i+7)+"."+(enemies.get(i+7)).name+"\t\t"+(i+14)+"."+(enemies.get(i+14)).name+"\t\t");
			}
			else if (i==8){
				System.out.println(i+"."+(enemies.get(i)).name+"\t\t"+(i+7)+"."+(enemies.get(i+7)).name+"\t"+(i+14)+"."+(enemies.get(i+14)).name+"\t\t");
			}
			else{
				System.out.println(i+"."+(enemies.get(i)).name+"\t\t"+(i+7)+"."+(enemies.get(i+7)).name+"\t\t"+(i+14)+"."+(enemies.get(i+14)).name+"\t\t");
			}


		}
		System.out.println("--------------------------------------------------------------");
		System.out.println("==============================================================");
	}
	
	public void pickTeam(){
		Scanner stdin = new Scanner(System.in);
		ArrayList<Integer> nums =  new ArrayList<Integer>();
		while(friends.size()<4){
			System.out.println("What is the ID of your chosen GhettoMon: ");
			int index = stdin.nextInt();
			enemies.get(index).displayStats(enemies.get(index));
			while(friends.contains(enemies.get(index))){
				System.out.println("You have already selected this GhettoMon, please re-select ");
				DisplayTable();
				System.out.println("Re-select: ");
				index = stdin.nextInt();
			}
			System.out.println("Do you still want this GhettoMon? (y/n): ");
			String yn = stdin.next();
			
			if (yn.equals("y")){
				nums.add(index);
				friends.add(enemies.get(index));
				DisplayTable();
			}
			else if (yn.equals("n")){
				DisplayTable();
				System.out.println("l");
			}		
		}
		Collections.sort(nums);
		for (int i=0;i<4;i++){
			enemies.remove(friends.get(i));
		}
		System.out.println("Your final team is : 0. "+friends.get(0).getName()+", 1. "+friends.get(1).getName()+", 2. "+friends.get(2).getName()+", 3. "+friends.get(3).getName()+". ");
		System.out.println("Out of the 4 GhettoMon, please select one to be your starter by entering their corresponding number ID: ");
		int activeChoice=stdin.nextInt();
		activePokemon=friends.get(activeChoice);
		activePokemon.displayStats(activePokemon);
	}
	
	public void chooseEnemy(){
		boolean newEnemy=true;
		Collections.shuffle(enemies);
		enemyPokemon=enemies.get(0);
		System.out.println("New enemy!!\n"+enemyPokemon.getName()+" has entered the arena!");
		displayBattle();
		
	}
	
	public void pickAction(){
		int choice=0;
		System.out.println("ENTER corresponding number to choose next action");
		System.out.println("|| [1. ATTACK ] || [2. SWAP] || [3. PASS] ||");
		choice=Integer.parseInt(stdin.next());
		if (choice>=1 && choice<=3){
			choice=Integer.parseInt(stdin.next());	
		}
		else{
			System.out.println("That is an invalid input, please try again");
			pickAction();
		}

		if (choice==1){
			activePokemon.userAttack(activePokemon, enemyPokemon);
		}
		else if (choice==2){
			swap();
		}
		else{
			System.out.println("You passed your turn");
		}

	}
	
	public void swap(){
		int pick;
		for (int i=0;i<friends.size();i++){
			System.out.println("Pokemon ID: "+i);
			friends.get(i).displayStats(friends.get(i));
		}
		System.out.println("Please enter the ID of the Pokemon that you would like to swap to: ");
		pick=stdin.nextInt();
		activePokemon=friends.get(pick);
		displayBattle();
	}
	
	public void checkDead(){
		if (activePokemon.getHP()<=0){
			System.out.println(activePokemon.getName()+" has fainted!");
			System.out.println("Please select a new active GhettoMon");
			friends.remove(activePokemon);
			swap();
		}
		if (enemyPokemon.getHP()<=0){
			System.out.println(enemyPokemon.getName()+" has fainted!");
			chooseEnemy();
		}
	}
	
	public void displayBattle(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		if (activePokemon.getName().length()<=6){
			System.out.println("\t"+activePokemon.getName()+" ("+activePokemon.getHP()+"/"+activePokemon.getTotHP()+")\t\tvs.\t\t"+enemyPokemon.getName()+" ("+enemyPokemon.getHP()+"/"+enemyPokemon.getTotHP()+")");
		}
		else{
			System.out.println("\t"+activePokemon.getName()+" ("+activePokemon.getHP()+"/"+activePokemon.getTotHP()+")  \tvs.  \t"+enemyPokemon.getName()+" ("+enemyPokemon.getHP()+"/"+enemyPokemon.getTotHP()+")");
		}
		
		System.out.println("");

		System.out.println("\tENERGY: "+activePokemon.getEnergy()+"\t\t\t\t\tENERGY: "+enemyPokemon.getEnergy());
		if (activePokemon.getType().equals("")){
			System.out.println("\tTYPE: "+activePokemon.getType()+"\t\t\t\t\t\t\t\tTYPE: "+enemyPokemon.getType());
		}
		if (activePokemon.getResistance().equals("")){
			System.out.println("\tRES: "+activePokemon.getResistance()+"\t\t\t\t\t\t\t\t\tRES: "+enemyPokemon.getResistance());
		}
		if (activePokemon.getWeakness().equals("")){
			System.out.println("\tWEAK: "+activePokemon.getWeakness()+"\t\t\t\t\t\t\tWEAK: "+enemyPokemon.getWeakness());
		}	
		if (activePokemon.getType().length()<=5){
			System.out.println("\tTYPE: "+activePokemon.getType()+"\t\t\t\t\tTYPE: "+enemyPokemon.getType());
		}
		if (activePokemon.getResistance().length()<=5){
			System.out.println("\tRES: "+activePokemon.getResistance()+"\t\t\t\t\tRES: "+enemyPokemon.getResistance());
		}
		if (activePokemon.getWeakness().length()<=5){
			System.out.println("\tWEAK: "+activePokemon.getWeakness()+"\t\t\t\t\tWEAK: "+enemyPokemon.getWeakness());
		}
		else{
			System.out.println("\tTYPE: "+activePokemon.getType()+"\t\t\t\tTYPE: "+enemyPokemon.getType());
			System.out.println("\tRES: "+activePokemon.getResistance()+"\t\t\t\t\tRES: "+enemyPokemon.getResistance());
			System.out.println("\tWEAK: "+activePokemon.getWeakness()+"\t\t\t\tWEAK: "+enemyPokemon.getWeakness());
		}
	}																			
	
	public void battle(){
		while (enemies.size()>0 && friends.size()>0){
    		if (newEnemy==true){
    			newEnemy=false;
    			int firstTurn= (int )(((Math.random() * 2 + 1)));
    			if (firstTurn==1){
    				System.out.println("You have the first move!");
    			}
    			else{
    				System.out.println(enemyPokemon.getName()+" has the first move!");
    			}
    		}
    		if (firstTurn==1){
    			pickAction();
    			checkDead();
    			enemyTurn(activePokemon,enemyPokemon);
    			checkDead();
    			displayBattle();
    		}
    		else{
    			enemyTurn(activePokemon,enemyPokemon);
    			checkDead();
    			pickAction();
    			checkDead();
    			displayBattle();
    		}
		}
		    		
	}
	
	
    	
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
