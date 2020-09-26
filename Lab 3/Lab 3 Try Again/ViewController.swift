//
//  ViewController.swift
//  Lab 3 Try Again
//
//  Created by Noelle Ireland on 9/24/20.
//  Copyright © 2020 Noelle Ireland. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageText: UILabel!
    @IBOutlet weak var imageControl: UISegmentedControl!
    @IBOutlet weak var roommateImage: UIImageView!
    @IBOutlet weak var fontLabel: UILabel!
    @IBOutlet weak var fontSize: UISlider!
    @IBOutlet weak var capitalSwitch: UISwitch!
    func updateImage(){
        if imageControl.selectedSegmentIndex == 0 {
            imageText.text="Max was mean yesturday 3/10"
             imageText.textColor=UIColor.systemPink
            roommateImage.image=UIImage(named:"max1")
        }
        else if
            imageControl.selectedSegmentIndex == 1 {
            imageText.text="Jackson made me coffee 8/10"
             imageText.textColor=UIColor.systemGreen
            roommateImage.image=UIImage(named:"jackson1")
        }
        else if
            imageControl.selectedSegmentIndex == 2 {
            imageText.text="Ben made really good chicken 6.5/10"
             imageText.textColor=UIColor.systemBlue
            roommateImage.image=UIImage(named:"ben1")
        }
    }
    func updateCapitals(){
           if capitalSwitch.isOn{
               imageText.text=imageText.text?.uppercased()
               } else {
                   imageText.text=imageText.text?.lowercased()
           }
    }
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
           updateImage()
            updateCapitals()
    }
        
  
    @IBAction func updateCap(_ sender: UISwitch) {
        updateCapitals()
    }
    @IBAction func fontSize(_ sender: UISlider) {
    
    let fontSize=sender.value //float
           fontLabel.text=String(format: "%.0f", fontSize) //convert float to String
           let fontSizeCGFloat=CGFloat(fontSize) //convert float to CGFloat
           imageText.font=UIFont.systemFont(ofSize: fontSizeCGFloat) //create a UIFont object and assign to the font property
       }

    
   
    
    
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

