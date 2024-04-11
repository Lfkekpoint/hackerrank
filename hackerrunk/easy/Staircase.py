# !/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'staircase' function below.
#
# The function accepts INTEGER n as parameter.
#

def staircase(n):
    for index in range(0, n):
        print(" "*(n-index-1) + "#"*(index+1))

if __name__ == '__main__':
    n = int(input().strip())

    staircase(n)
