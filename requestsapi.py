import requests
from pprint import pprint
from bs4 import BeautifulSoup
import re
from PIL import Image

def buildFile(res):
    f = ''
    with open('response.html', 'w') as file:
        f  = file.write(res.text) 
    return f    

def extractImages():
    with open('response.html', 'r') as file:
        soup = BeautifulSoup(file, 'html.parser')
        for tags in soup.find_all('a'):
            images.append(tags.get('href'))
    return images    



headers = {'Accept-Encoding': 'identity'}
url = 'https://onanimation.com/2019/01/13/the-art-and-making-of-spider-man-into-the-spider-verse/'
res = requests.get(url, headers=headers)
images = []

extractImages()

def is_downloadable(url):
    """
    Does the url contain a downloadable resource
    """
    h = requests.head(url, allow_redirects=True)
    header = h.headers
    content_type = header.get('content-type')
    if 'text' in content_type.lower():
        return False
    if 'html' in content_type.lower():
        return False
    return True

#page = buildFile(res)
for item in range(len(images)):
    if re.search(r'[.*]jpg', str(images[item])):
       if is_downloadable(images[item]) == True:
           r = requests.get(images[item], allow_redirects=True)
           open('images/image' + str(item), 'wb').write(r.content)
        

