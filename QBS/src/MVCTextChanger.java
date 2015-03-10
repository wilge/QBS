
public class MVCTextChanger
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		TextChangerModel model = new TextChangerModel();
		TextChangerView view = new TextChangerView();
		TextChangerController controller = new TextChangerController(model, view);
		

	}

}
