//
//  ViewController.swift
//  ImagePicker
//
//  Created by Noelle Ireland on 10/12/20.
//  Copyright © 2020 Noelle Ireland. All rights reserved.
// Image Code for Photo Library and Camera based on video https://www.youtube.com/watch?v=CcYcb7v4-M8
//Random Code from Apple Developer Ste
//Text Box Field code from Lab 4
//Buttons from class

import UIKit

class ViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate, UITextFieldDelegate{
    
    @IBOutlet weak var nameInput: UITextField!
    
    @IBOutlet weak var imageView: UIImageView!
    
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var changeCaptionLabel: UILabel!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    let imageChoice = UIImagePickerController()
    
    @IBAction func resetButton(_ sender: UIButton) { //reset everything
        if sender.tag==0 {
            changeCaptionLabel.text = ""
            nameInput.text = ""
            imageView.image = UIImage(named: "Upload")
            nameLabel.text = ""
            
        }
    }
    @IBAction func runButton(_ sender: UIButton) { //when butotn clicked
        let insults = ["They have a plentiful lack of wit." , "It is a tale told by an idiot, full of sound and fury, signifying nothing." , "His wit’s as thick as a Tewkesbury mustard." , "Your abilities are too infant-like for doing much alone." , "If thou wilt needs marry, marry a fool; for wise men know well enough what monsters you make of them." , "More of your conversation would infect my brain." , "Thou sodden-witted lord! Thou hast no more brain than I have in mine elbows!", "Your brain is as dry as the remainder biscuit after voyage." , "If you spend word for word with me, I shall make your wit bankrupt.", "He has not so much brain as ear-wax.", "Thou art the cap of all the fools.", "Away thou rag, thou quantity, thou remnant.", "Foul spoken coward, that thund’rest with thy tongue, and with thy weapon nothing dares perform.", "Go, prick thy face, and over-red thy fear, Thou lily-liver’d boy." , "You, minion, are too saucy.", "I must tell you friendly in your ear, sell when you can, you are not for all markets.", "I scorn you, scurvy companion.", "You are not worth another word, else I’d call you knave.", "Thou whoreson zed, thou unnecessary letter!", "Thy sin’s not accidental, but a trade." , "A fool, an empty purse. There was no money in’t.", "Thy tongue outvenoms all the worms of Nile." , "Away, you mouldy rogue, away!", "Would thou wert clean enough to spit upon." , "I do desire that we may be better strangers." , "You are as a candle, the better burnt out." , "Dutchman’s beard." , "Threadbare juggler!", "Eater of broken meats!", "Saucy lackey!", "What an ass", "What a thrice-double ass!", "Poisonous bunch-backed toad!", "Here is the babe, as loathsome as a toad.", "Like the toad; ugly and venomous.",  "Thou cream faced loon!", "A rare parrot-teacher!", "Come, come, you froward and unable worms!", "Pigeon-liver’d and lack gall.", "You have such a February face, so full of frost, of storm and cloudiness.", "I am sick when I do look on thee.", "Out of my sight! thou dost infect my eyes.", "Thou art a boil, a plague sore, an embossed carbuncle in my corrupted blood.", "Thou lump of foul deformity.", "I’ll beat thee, but I would infect my hands. (For legal reason, please maintain 6 feet apart)", "Your virginity breeds mites, much like a cheese.", "Villain, I have done thy mother.", "Away, you three-inch fool!", "Thou art unfit for any place but hell.", "Thou damned and luxurious mountain goat.", "Thou elvish-mark’d, abortive, rooting hog", "You scullion! You rampallian! You fustilarian! I’ll tickle your catastrophe!", "Bloody, bawdy villain! Remorseless, treacherous, lecherous, kindless villain!"]
        let randomInsults = insults.randomElement()! //randomly choose inslut from list
        print(randomInsults) // print random insult to check
        
        if sender.tag == 1 { //if button pressed -- do things
            changeCaptionLabel.text = randomInsults
            infoUpdate()
              
               
            }
    }
    @IBAction func addPhotoButton(_ sender: Any) {
        
         let alert = UIAlertController(title: nil, message: nil, preferredStyle: .actionSheet)
         
        alert.addAction(UIAlertAction(title: "Photo Gallery", style: .default, handler: { (button) in
                   self.imageChoice.sourceType = .photoLibrary
                   self.present(self.imageChoice, animated: true, completion: nil)
               }))
               
               alert.addAction(UIAlertAction(title: "Camera", style: .default, handler: { (button) in
                   self.imageChoice.sourceType = .camera
                   self.present(self.imageChoice, animated: true, completion: nil)
               }))
               
               alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: nil))
        
                present(alert, animated: true, completion: nil)
            }
    
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
                
        guard let selectedImage = info[UIImagePickerController.InfoKey.editedImage] as? UIImage else { return }
                imageView.image = selectedImage
                dismiss(animated: true, completion: nil)
            }
    func infoUpdate() {
        var name:String
        if nameInput.text!.isEmpty {
           name = ""
            changeCaptionLabel.text = String(nameInput.text!)
        } else {
            name = String(nameInput.text!)
            nameLabel.text = String(nameInput.text!)
        }
    }
 
    override func viewDidLoad() {
        nameInput.delegate = self
        imageChoice.delegate = self
        imageChoice.allowsEditing = true
         super.viewDidLoad()
        // Do any additional setup after loading the view.
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.getRidofKeyboard))
            view.addGestureRecognizer(tap)
    }
    @objc func getRidofKeyboard() {
            view.endEditing(true)
    }
    
}


