//
//  ViewController.swift
//  Lab 4
//
//  Created by Noelle Ireland on 10/5/20.
//  Copyright © 2020 Noelle Ireland. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet weak var rentInput: UITextField!
    @IBOutlet weak var utilitiesInput: UITextField!
    @IBOutlet weak var foodInput: UITextField!
    @IBOutlet weak var roommateStepper: UIStepper!
    @IBOutlet weak var numOfRoommatesLabel: UILabel!
    @IBOutlet weak var totalDueLabel: UILabel!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBAction func updatePeople(_ sender: UIStepper) {
        if roommateStepper.value == 1 {
            numOfRoommatesLabel.text = "1 Roommate"
        } else {
            numOfRoommatesLabel.text = String(format: "%.0f", roommateStepper.value) + " Roommates"
        }
        updateTotalCost()
    }
    func updateTotalCost() {
        var rentAmount:Float //rent amount
        var utilitiesAmount:Float //utilities amount
        var foodPrice: Float // personal food cost
        
        if rentInput.text!.isEmpty {
           rentAmount = 0.0
        } else {
            rentAmount = Float(rentInput.text!)!
        }
        if utilitiesInput.text!.isEmpty {
            utilitiesAmount = 0.0
        }
        else {
            utilitiesAmount = Float(utilitiesInput.text!)!
        }
        if foodInput.text!.isEmpty {
                  foodPrice = 0.0
              }
              else {
                  foodPrice = Float(foodInput.text!)!
              }
        let numOfRoommates = roommateStepper.value
        let sharedExpense=rentAmount + utilitiesAmount
        //let total=amount+tip
        var perPersonTotal : Float = 0.0
        
        if numOfRoommates == 0 {
        perPersonTotal = (sharedExpense + foodPrice)
        
        } else if numOfRoommates < 4 {
            perPersonTotal = (sharedExpense / (Float(numOfRoommates)+1)) + foodPrice
        } else {
            //UIAlertController object
            let alert=UIAlertController(title: "Warning", message: "It is against City of Boulder laws to have more than 3 unrelated people living together.", preferredStyle: UIAlertController.Style.alert)
            //UIAlertAction object for the button
                let cancelAction=UIAlertAction(title: "Break the Law", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction) //add alert action to the alert object
            let okAction=UIAlertAction(title: "Be Legal", style: UIAlertAction.Style.default, handler: {action in
                self.roommateStepper.value = 3
                self.numOfRoommatesLabel.text? = "3 Roommates"
                self.updateTotalCost()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
            } //end else
        
        //in currency form
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle=NumberFormatter.Style.currency //set number style
        totalDueLabel.text=currencyFormatter.string(from: NSNumber(value: perPersonTotal)) //returns formatted string

    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTotalCost()
    }
    
    override func viewDidLoad() {
        rentInput.delegate=self
        utilitiesInput.delegate=self
        foodInput.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.getRidofKeyboard))
            view.addGestureRecognizer(tap)
        }

        @objc func getRidofKeyboard() {
            view.endEditing(true)
    }


}

