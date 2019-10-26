package blockchain;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

/**
 * This class represents the Block Model 
 * 
 * @author Yatin Kharbe
 *
 */
public class Block {
	
	/**
	 * Integer variable for index
	 */
	private int index;
	
	/**
	 * String variable for hash
	 */
	private String hash ;
	
	/**
	 * String variable for previousHash
	 */
	private String previousHash;
	
	/**
	 * String variable for data
	 */
	private String data ;
	
	
	/**
	 * Getter method for hash
	 * 
	 * @return String hash value 
	 */
	public String getHash() {
		return hash;
	}


	/**
	 * Setter method for hash
	 * 
	 * @param hash - String hash value to be passed 
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * Integer value for index
	 * 
	 * @return - integer index value
	 */
	public int getIndex() {
		return index;
	}


	/**
	 * Setter method for index
	 * 
	 * @param index - Integer value for index
	 */
	public void setIndex(int index) {
		this.index = index;
	}


	/**
	 * Getter method for previousHash
	 * 
	 * @return - returns previousHash String value
	 */
	public String getPreviousHash() {
		return previousHash;
	}


	/**
	 * Setter method for previousHash
	 * 
	 * @param previousHash - String value for previousHash
	 */
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	/**
	 * Getter method for data 
	 * 
	 * @return - String value for data 
	 */
	public String getData() {
		return data;
	}

	/**
	 * Setter method for data
	 * 
	 * @param data - String value for data 
	 */
	public void setData(String data) {
		this.data = data;
	}

	
	/**
	 * Constructor for Block
	 * 
	 * @param index - integer to be passed
	 * @param previousHash - String value for previousHash
	 * @param data - String value for data
	 */
	public Block(int index  , String previousHash , String data)
	{
		this.index = index;
		this.hash = getSHA256Hash(index+previousHash+data);
		this.previousHash = previousHash;
		this.data = data;
		
	}
	
	/**
	 * Method to get SHA256Hash 
	 * 
	 * @param data - String data passed 
	 * @return - returns String Hash data 
	 */
	private String getSHA256Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
	
	/**
	 * Method to convert bytes to hex
	 * 
	 * @param hash - byte code to be passed 
	 * @return - returns String hex value 
	 */
	 private String  bytesToHex(byte[] hash) {
	        return DatatypeConverter.printHexBinary(hash);
	    }

}
