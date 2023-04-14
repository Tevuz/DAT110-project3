package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	/**
	 * @param entity string to hash
	 * @return MD5 hash of entity
	 */
	public static BigInteger hashOf(String entity) {
		try {

			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			return new BigInteger(1, messageDigest.digest(entity.getBytes()));

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return address size of MD5 hash
	 */
	public static BigInteger addressSize() {
		return BigInteger.ZERO.setBit(bitSize());
	}

	/**
	 * @return bit size of MD5 hash
	 */
	public static int bitSize() {
		try {

			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			int digestLength = messageDigest.getDigestLength();

			return digestLength * 8;

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
