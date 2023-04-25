using System.Collections;
using System.Collections.Generic;
using System.Threading;
using UnityEngine;
using UnityEngine.UI;

public class ActionMenu : MonoBehaviour
{
	private GameManager gameManager;
	private Button interactButton;
	private TMPro.TextMeshProUGUI turnIndicator;
	private TMPro.TextMeshProUGUI forfeitText;

	// Start is called before the first frame update
	void Start()
    {
		gameManager = GameObject.Find("Game Manager").GetComponent<GameManager>();
		interactButton = GameObject.Find("Interact Button").GetComponent<Button>();
		turnIndicator = GameObject.Find("Turn Indicator").GetComponent<TMPro.TextMeshProUGUI>();
		forfeitText =  GameObject.Find("Forfeited Text").GetComponent<TMPro.TextMeshProUGUI>();
	}

	public void OnInteractClick()
	{
		gameManager.StartInteraction();
	}

	public void OnForfeitClick()
	{
		gameManager.Forfeit();
	}

	public void OnTauntClick()
	{
		gameManager.Taunt();
	}

	void Update()
	{
		interactButton.interactable = gameManager.CanInteract();
		turnIndicator.text = gameManager.GetCurrentPlayer().Name + "'s turn";
	}
}
