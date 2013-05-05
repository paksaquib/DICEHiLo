package DiceHiLo;

import javax.swing.JOptionPane;

public class Dice {

	private static int Hibound;
	private static int Lobound;
	
	//Create constructor to fix value
	public Dice (int Hibound1, int Lobound1 )
	{
		Hibound = Hibound1;
		Lobound = Lobound1;
	} 
	
	//To generate a random number between 1 to 6
    static int GetANumber(){
        int randomNum = 0;
        randomNum = 1 + (int)(Math.random()*6);
        return randomNum;
    }	
	
    
    //Create method to Check Winner
	static boolean CheckUserWin(int userMove,  int CNumber)
	{
		boolean userwins = false;
		if ((CNumber <=Lobound && userMove == 0) || (CNumber <= Hibound && CNumber > Lobound && userMove == 1))
		{
			userwins = true;
		}
		return userwins;
	}
    
	//Create method to display a winner
	static void displayWinner(int usermove, boolean userwin)
	{
		
		if (userwin == true)
		{
			if (usermove == 1)
			{
				JOptionPane.showMessageDialog(null,"You Win \n Both Choose High");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You Win \n Both Choose Low");
			}
		}
		else
		{
			if (usermove == 1)
			{
				JOptionPane.showMessageDialog(null,"Computer Wins \n You choose High\n Computer choose low");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Computer Wins \n You choose Low\n Computer choose High");
			}
		}		
	}
	
	
	public static void main( String[] args)
	 {
		int Usermove = 0;
		int UserDiceSelection = 0;
		int computernumber = 0;
		boolean userwins = false;
		
		//User input for no of dice selection
		UserDiceSelection = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter\n1 if you want to play with one dice\n 2 if you want to play with two dice \n "));
			
		//If user play with one dice
		if (UserDiceSelection == 1)
		{	
			Dice d1 = new Dice(6,3);
			computernumber = GetANumber();
		}
		//If user play with two dice
		else if (UserDiceSelection == 2)
		{
			Dice d1 = new Dice(12,6);
			computernumber = GetANumber() + GetANumber(); 
		}
		
		Usermove = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter\n1 For High\n 0 for Low \n "));
		userwins = CheckUserWin(Usermove,computernumber);
		displayWinner(Usermove,userwins);

	 }
	
}


/*
70 Points
Define a class Dice that returns a number between 1-6
Use class Dice in a program to implement a Hi-Lo game where user guess 1-3 as
low and 4-6 as high


20 Points
Use multiple Dice object to implement a multi-Dice Hi-Lo game (for 2 dices, 1-6
is low and 7-12 is high)


10 Points
Use multiple methods


10 Points
Use constructors
*/