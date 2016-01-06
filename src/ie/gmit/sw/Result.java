package ie.gmit.sw;

public class Result implements Resultable  {
	
	private String plainText;
	private double score;
	private int key;

	public Result(String plainText, double score, int key) {
		super();
		this.plainText = plainText;
		this.score = score;
		this.key = key;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#getPlainText()
	 */
	@Override
	public String getPlainText() {
		return plainText;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#setPlainText(java.lang.String)
	 */
	@Override
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#getScore()
	 */
	@Override
	public double getScore() {
		return score;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#setScore(double)
	 */
	@Override
	public void setScore(double score) {
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#getKey()
	 */
	@Override
	public int getKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Resultable#setKey(int)
	 */
	@Override
	public void setKey(int key) {
		this.key = key;
	}


}
