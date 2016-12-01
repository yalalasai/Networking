#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector <int> arr;
    string s;
    cin >> s;
    int i = 0;
    int num = 0;
    while(s[i] != '\0')
    {
        arr.push_back(s[i]);
        i++;
    }
    vector <int> :: iterator it;
    for(it = arr.begin(); it != arr.end(); it++)
    {
        if(*it != '.')
            num = num * 10 + (*it - '0');
        else
            break;
    }
    cout << num;
    int z = num;

    if(0 <= num && num <= 127)
        cout << "Class A";

    else if(128 <= num && num <= 191)
        cout << "Class B";

    else if(192 <= num && num <= 223)
        cout << "Class C";

    else if(224 <= num && num <= 239)
        cout << "Class D";

    else    
        cout <<"Non-Applicable Class";
    return 0;

}