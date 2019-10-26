package blockchain;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to demonstrate Simple Blockchain program
 * 
 * Genesis Block - Its the first Block or Block 0 of blockchain list .
 * Other blocks are added after the Genesis block in a sequential manner 
 * 
 * The below program works as below 
 * 
 * 1. Creates a Gensis block starting with index 0 , previousHash as 0  and Data as Blockchain Data 0 .
 * 2. Block 1 is created on index 1 , previousHash is a hash processed from previousHash data and Data as Blockchain Data 1. 
 * 3. Block 2 is created on index 2 , previousHash is a hash processed from previousHash data from Block 1 and Data as Blockchain Data 2.
 * 
 * The details of all this are printed out .
 * 
 * @author Yatin Kharbe
 *
 */
public class Blockchain {

	public static void main(String[] args) {

		List<Block> blockChainList =  new ArrayList<>();
		Block genesis = new Block(0, "0" , "Blockchain Data 0");
		blockChainList.add(genesis);

		Block block1 = new Block(1, blockChainList.get(blockChainList.size()-1).getHash() , "Blockchain Data 1");
		blockChainList.add(block1);

		Block block2 = new Block(2, blockChainList.get(blockChainList.size()-1).getHash() , "Blockchain Data 2");
		blockChainList.add(block2);


		for (int i = 0; i < blockChainList.size(); i++) {

			System.out.println("Block Chain Data \n ");

			System.out.println("\n Block Index "+ i);

			System.out.println(" Block Chain Previous Hash "+blockChainList.get(i).getPreviousHash());

			System.out.println(" Block Chain Data "+blockChainList.get(i).getData());

			System.out.println(" Block Chain Hash "+blockChainList.get(i).getHash());

			System.out.println("==========================================================================");
		}

	}

}
