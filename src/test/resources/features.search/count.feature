@wordCounter
Feature: Word counter at www.wordcounter.net
  As a WordCounter.net user
  I want to count the words in a text
  To check the accuracy of the word counter

  Background: open the home page
    Given Elvis is on the word counter home page

  Scenario: Validate that Counting worlds function work correctly
    When he wants to use the word counter functionality with the following paragraph
    """
    This is a test for Lumu.
    This is a test for Lumu.
    Test automation for using SerenityBDD.
    This is a test for Lumu.
    """
    Then he should be able to see the text "23 words 110 characters"

  Scenario: Validate that the keyword Density sum is equal to 100%
    When he wants to use the word counter functionality with the following paragraph
    """
    This is a test for Lumu.
    This is a test for Lumu.
    Test automation for using SerenityBDD.
    This is a test for Lumu.
    """
    Then he should be able to see the text "23 words 110 characters"
    And he should be able to see that the sum of the all keyword density is 100%

  Scenario: Checking the three most repeated words
    When he wants to use the word counter functionality with the following paragraph
    """
    This is a test for Lumu.
    This is a test for Lumu.
    Test automation for using SerenityBDD.
    This is a test for Lumu.
    """
    Then he should see that the site displays the three most repeated words as:
      | word       | timesRepeated |
      | test       | 4 (40%)       |
      | lumu       | 3 (30%)       |
      | automation | 1 (10%)       |

  Scenario:  Verify the number of words in a given paragraph
    When he wants to use the word counter functionality with the following paragraph
    """
    This is a test case to verify the word count.
    """
    Then he should see display the word count correctly as "10"

  Scenario: Verify the number of characters
    When he wants to use the word counter functionality with the following paragraph
    """
    This is a test case to verify the word count.
    """
    Then he should see display the number of characters correctly as "45"

  Scenario: Check behavior of special characters
    When he enters text containing special characters such as "!@#$%^&*()"
    Then he should see display the number of characters correctly as "10"

  Scenario: Validate the functionality of the button, clear undo and redo
    When he wants to use the buttons clear, undo and redo in the same operation
    """
    This is a test.
    """
    Then he should see the counter with the text : "0 words 0 characters"




