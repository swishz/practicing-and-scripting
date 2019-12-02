#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 14 23:51:11 2018

@author: enrique
"""
text = 'ktwyfqjef'
k = 5
decr = ''

for i in text.upper():
    if (ord(i) - k) < 65:
        decr += chr((ord(i) - k) + 26)
    else: 
        decr += chr(ord(i) - k)
    
decr