//
//  ViewController.swift
//  Lab 1
//
//  Created by Noelle Ireland on 9/10/20.
//  Copyright © 2020 Noelle Ireland. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var personImage: UIImageView!
    
    @IBOutlet weak var changeCaption: UILabel!
    
    @IBAction func changeImage(_ sender: UIButton) {
        if sender.tag == 1{
            personImage.image = UIImage(named: "Ben")
            changeCaption.text="This is Ben. He's the worst."
        }
        
        else if sender.tag == 2{
            personImage.image = UIImage(named: "Max")
            changeCaption.text="This is Max. He's the also the worst."
        }
            
        else if sender.tag == 3{
        personImage.image = UIImage(named: "Jackson")
            changeCaption.text="This is Jackson. He's the worst of them all."
        }
        
    }
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

